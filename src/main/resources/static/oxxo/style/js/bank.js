/**
 * Created by user on 2017/7/7.
 */
/**
 * Created by cendechen on 2015/8/28.
 */
(function(){
    var svg,
        width,
        height,
        color,
        bubble;
    var s = {
        init: function () {
            width = $(".draw-section").width() - 10;
            height = $(".draw-section").height() - 100;
            color = d3.scale.category20();
            d3.select(".customer").style("padding-top", "80px");
        },
        createBubble: function () {
            var maxRaius = 70;
            var rScale = d3.scale.sqrt().range([35,maxRaius]).clamp(true);
            function rvalue(da){
                return parseInt(da.v);
            }
            function rname(da){
                return s.filter(da.n);
            }
            var collisionPadding = 4;//间距
            var minCollisionRadius = 12  ;
            var jitter = 0.2  ;//缩放比例

            function transformData(rawData){
                rawData.forEach(function(d){
                    d.v = parseInt(d.v);
                })
                rawData.sort(function(a,b){
                    return b.v - a.v;
                })
                var range = d3.range(0,10);
                var color = d3.scale.ordinal().domain(range).rangeRoundPoints([0xff3333,0xff0000]);
                for(var i = 0;i < rawData.length;i++){
                    if(i < 10){
                        rawData[i].fillcolor = "#"+color(i).toString(16);
                    }else{
                        rawData[i].fillcolor = "rgb(31, 119, 180)"
                    }
                }
                rawData.sort(function(){
                    return  0.5 - Math.random();
                })
                return rawData;
            }
            function tick(e){
                var dampenedAlpha = e.alpha * 0.1;
                node.each(gravity(dampenedAlpha))
                    .each(collide(jitter))
                    .attr("transform",function(d){ return "translate("+ d.x+","+ d.y+")"});
                label.style("left",function(d){
                    return  d.x - d.dx /2 +"px";
                }).style("top", function(d){
                    return d.y - d.dy / 2 +"px";
                })
            }
            var force = d3.layout.force().gravity(0).charge(0).size([width,height]).on("tick",tick);
            var data,node,label;
            var chart = function(selection){
                selection.each(function(rawData){
                    data = transformData(rawData);
                    var  maxDomainValue = d3.max(data,function(d){return rvalue(d);})
                    rScale.domain([0,maxDomainValue]);
                    var svg = d3.select(this).selectAll("svg").data([data])
                    svgEnter = svg.enter().append("svg")
                    svg.attr("width",width);
                    svg.attr("height",height);
                    node = svgEnter.append("g").attr("id","bubble-nodes");
                    node.append("rect")
                        .attr("id", "bubble-background")
                        .attr("width", width)
                        .attr("height", height)
                        .attr("fill","none")

                    label = d3.select(this).selectAll("#bubble-labels").data([data])
                        .enter()
                        .append("div")
                        .attr("id", "bubble-labels");
                    update();
                    function update(){
                        data.forEach(function(d,i){
                            d.forceR = Math.max(minCollisionRadius,rScale(rvalue(d)))
                        })
                        force.nodes(data).start();
                        updateNodes();
                        updateLables();
                    }
                    function updateNodes(){
                        node = node.selectAll(".bubble-node").data(data,function(d){
                            return rvalue(d);
                        })
                        node.exit().remove();
                        node.enter().append("a")
                            .attr("class","bubble-node")
                            .style("fill",function(d){
                                return d.fillcolor;
                            })
                            .call(force.drag)
                            .call(connectEvents)
                            .append("circle")
                            .attr("r",function(d){return rScale(rvalue(d))});

                    }
                    function updateLables(){
                        label = label.selectAll(".bubble-label").data(data, function(d){return rvalue(d)})
                        label.exit().remove();
                        labelEnter = label.enter().append("a")
                            .attr("class","bubble-label")
                            .call(force.drag)
                            .call(connectEvents)
                        labelEnter.append("div")
                            .attr("class", "bubble-label-name")
                            .text(function(d){
                                return  rname(d);
                            })
                        labelEnter.append("div")
                            .attr("class", "bubble-label-value")
                            .text(function(d){
                                return rvalue(d);
                            })
                        label.style("font-size", function(d){return  Math.max(8, rScale(rvalue(d))/4) + "px"})
                            .style("width", function(d){return  2.5 * rScale(rvalue(d)) + "px"})
                        label.append("span").text(function(d){return rname(d);})
                            .each(function(d){ d.dx = Math.max(2.5 * rScale(rvalue(d)), this.getBoundingClientRect().width)})
                            .remove()
                        label.style("width", function(d){ return d.dx + "px"})
                        label.each(function(d){d.dy = this.getBoundingClientRect().height})
                    }
                    function connectEvents(d){
                        d.on("mouseover",mouseover)
                        d.on("mouseout",mouseout);
                    }
                    function mouseover(d){
                        node.classed("bubble-hover",function(p){
                            return p == d;
                        })
                    }
                    function mouseout(d){node.classed("bubble-hover",false);}
                })

            }
            function gravity(alpha){
                var cx = width / 2;
                var cy = height / 2;
                var ax = alpha / 8;
                var ay = alpha;
                return function (d){
                    d.x += (cx - d.x) * ax;
                    d.y += (cy - d.y) * ay;
                }
            }
            function collide(jitter){
                return function(d){
                    data.forEach(function(d2){
                        if(d !=d2){
                            var x = d.x - d2.x;
                            var y = d.y - d2.y;
                            var distance = Math.sqrt(x*x +y*y);
                            var minDistance = d.forceR + d2.forceR + collisionPadding;
                            if (distance < minDistance){
                                distance = (distance - minDistance) / distance * jitter ;
                                var moveX = x * distance ;
                                var moveY = y * distance
                                d.x -= moveX
                                d.y -= moveY
                                d2.x += moveX
                                d2.y += moveY }
                        }
                    })
                }
            }
            return chart;
        },
        filter:function(d){
            return d.replace("联合社","").replace("股份有限公司","").replace("信用卡中心","").replace("（借记卡）","");
        },
        setlist: function (w, l) {
            var html = "<span class='title'>{$title}</span><span class='level'>{$level}</span>";
            return html.replace("{$title}", w).replace("{$level}", l);
        },
        setCaseList: function (e) {
            var html  = "<div class='pull-left bank-caseli'>"+
                "<p>{$engine}</p>"+
                "</div>";
            return html.replace("{$engine}",e);
        },
        createHaomaBar: function (d) {
            d.sort(function(a,b){
                return parseInt(b.v) - parseInt(a.v);
            });
            d = d.slice(0,15);
            d3.select(".bank-catelist").selectAll("li").data(d).enter().append("li").html(function (d) {
                return s.setlist(s.filter(d.n),d.v)
            });
        },
        createCase: function (d) {
            d.sort(function(){
                return Math.random() - 0.5;
            })
            d3.select(".bank-case").selectAll("li").data(d).enter().append("li").html(function(d){
                return s.setCaseList(d.n);
            })
            s.animate(".bank-case");
        },
        animate:function(element){
            var stime;
            function cc() {
                var h = $(element).find("li").eq(0).height();
                $(element).animate({"marginTop": -h}, 800, function () {
                    var domli = $(element).find("li").eq(0).clone();
                    $(element).append(domli);
                    $(element).css("marginTop", "0px").find("li").eq(0).remove();
                })
            }
            clearInterval(stime);
            $(element).on("mouseenter",function(){
                clearInterval(stime);
            }).on("mouseleave",function(){
                stime = setInterval(cc,2000);
            });
            stime = setInterval(cc,2000);
        }
    }
    $(function() {
        $.ajax({
            "url": "/account/front/webchat/bubbles",
            "type": "get",
            "dataType": "json"
        }).done(function (a) {
            s.init();
            var plot = s.createBubble()
            d3.select(".bank-content").datum(a.data).call(plot);
            s.createHaomaBar(a.data);
        }).fail(function (e) {
            alert("数据加载失败");
        })
        /*$.ajax({
            "url": "/lib/index.php?m=bank&a=get_exsample",
            "type": "get",
            "dataType": "json"
        }).done(function (d) {
            s.createCase(d.data);
        }).fail(function (e) {
            alert("数据加载失败！");
        })*/
    })
})()