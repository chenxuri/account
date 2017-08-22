/**
 * Created by user on 2017/7/6.
 */

$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    /* var oButtonInit = new ButtonInit();
     oButtonInit.Init(); */

    //条件查询
    $('#conditionquery').click(function(){
        $table.bootstrapTable('refresh');
    });

});

var $table = $('#bootstrapTable');
function operateFormatter(value, row, index) {
    var result = [];
    switch (row.status){
        case '0':
            result.push('<a class="start btn btn-success m-r-5 m-b-5" href="javascript:void(0)" title="启动">启动</a> ');
            break;
        case '1':
            result.push('<a class="stop  btn btn-success m-r-5 m-b-5" href="javascript:void(0)" title="关闭">关闭</a>');
            break;
        case '2':
            result.push('<a class="start btn btn-success m-r-5 m-b-5" href="javascript:void(0)" title="启动">启动</a> ');
            break;

    }
    result.push('<a class="modyCookie  btn btn-success m-r-5 m-b-5" href="javascript:void(0)" title="修改Cookie">修改Cookie</a>')
   return result.join(",");
}
window.operateEvents = {
    'click .start': function (e, value, row, index) {
        $.post(baseURL+"/spider/crawler/start", {id:row.id},
            function(data){
                if(data == '1'){
                    alert("操作成功");
                    $table.bootstrapTable('refresh');
                }else {
                    alert("操作失败");
                }
            });
    },
    'click .stop': function (e, value, row, index) {
        $.post(baseURL+"/spider/crawler/stop", {id:row.id},
            function(data){
                if(data == '1'){
                    alert("操作成功");
                    $table.bootstrapTable('refresh');
                }else {
                    alert("操作失败");
                }
            });
    }, 'click .modyCookie': function (e, value, row, index) {

        $("#form-cookie").find('input[name="id"]').val(row.id);
        $("#form-cookie").find('input[name="crawler"]').val(row.crawler);
        $("#form-cookie").find('textarea[name="cookie"]').val(row.cookie);
        $("#modal-modify_cookie").modal("show");
    }
};

function modifyCookie() {
    var data = {
        id:$("#form-cookie").find('input[name="id"]').val(),
        crawler:$("#form-cookie").find('input[name="crawler"]').val(),
        code:$("#form-cookie").find('input[name="code"]').val(),
        type:$("#form-cookie").find('input[name="type"]').val(),
        accountType:$("#form-add").find("select[name='accountType'] option:selected").val(),
        accountTypeName:$("#form-add").find("select[name='accountType'] option:selected").text(),
        cookie:$("#form-cookie").find('textarea[name="cookie"]').val()
    }
    $.ajax({
        type:"POST",
        url:baseURL+"/spider/crawler/modifyCookie",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(data){
            if(data == '1'){
                alert("操作成功");
                $table.bootstrapTable('refresh');
            }else {
                alert("操作失败");
            }
            $("#modal-modify_cookie").modal("hide");
        }
    });
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $table.bootstrapTable({
            url: baseURL+'/spider/crawler/list',     //请求后台的URL（*）
            method: 'get',           //请求方式（*）
            classes:'table table-hover table-bordered',
            /*toolbar: '#toolbar',        //工具按钮用哪个容器
            striped: true,       */    //是否显示行间隔色
            cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,          //是否显示分页（*）
            sortable: false,           //是否启用排序
            sortOrder: "asc",          //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,            //初始化加载第一页，默认第一页
            pageSize: 20,            //每页的记录行数（*）
            pageList: [20, 50, 100],    //可供选择的每页的行数（*）
            strictSearch: false,
            clickToSelect: false,        //是否启用点击选中行
            //height: 460,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",           //每一行的唯一标识，一般为主键列
            cardView: false,          //是否显示详细视图
            detailView: false,          //是否显示父子表
            columns: [{
                field: 'checkbox',
                checkbox: true,
                align: 'center',
                valign: 'middle'
            },{
                field: 'index',
                title: '序号',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index) {
                    return index+1;
                }
            }, {
                field: 'crawler',
                title: '爬虫',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'url',
                title: '网址',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index) {
                    return '<a href="'+value+'"  target="_blank" >'+value+'</a>'

                }
            }, {
                field: 'status',
                title: '状态',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index) {
                   switch (value){
                      /* 1运行 2 停止 3 异常*/
                       case 0:
                           return '未运行';
                       case 1:
                           return '运行';
                       case 2:
                           return '停止';
                       case 3:
                           return '异常';
                       default:
                           return '未运行';
                   }
                }
            },{
                field: 'createTime',
                title: '创建时间',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {

        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNum: params.pageNum,
            pageSize: params.pageSize,
            sort: params.sort,
            order: params.order,
            crawler:$('#form-search').find("input[name='crawler']").val()
        };
       /* console.log(temp);
        console.log(JSON.stringify(temp));*/
        return temp;
    };
    return oTableInit;
};


var addParsley = $('#form-add').parsley();

function add() {
    addParsley.validate();
    if(addParsley.isValid()){
        var saveData = {
            crawler:$("#form-add").find('input[name="crawler"]').val(),
            code:$("#form-add").find('input[name="code"]').val(),
            type:$("#form-add").find('input[name="type"]').val(),
            accountType:$("#form-add").find("select[name='accountType'] option:selected").val(),
            accountName:$("#form-add").find("select[name='accountType'] option:selected").text(),
            url:$("#form-add").find('input[name="url"]').val(),
            cookie:$("#form-add").find("textarea[name='cookie']").val()
        };
        $.ajax({
            type:"POST",
            url:baseURL+"/spider/crawler/add",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(saveData),
            success:function(data){
                if(data == '1'){
                    alert("添加成功");
                    $table.bootstrapTable('refresh');
                    $("#modal-add").modal("hide");
                    addParsley.reset()
                }else {
                    alert("添加失败");
                }

            }
        });
    }
}

var records;

function remove() {
    records = $table.bootstrapTable('getSelections');
    if(records.length < 1){
        alert("请选择至少一条数据！");
        return;
    }
    var idAr = [];
    //console.log(records);
    for(var i=0;i<records.length;i++){
        idAr.push(records[i].id);
    }
    //console.log(idAr);
    $.ajax({
        type:'post',
        traditional :true,
        url:baseURL+'/spider/crawler/delete',
        data:{ids:idAr},
        success:function(data){
            if(data == '1'){
                alert("删除成功");
                $table.bootstrapTable('refresh');
            }else {
                alert("删除失败");
            }
        }
    });
}

function start() {
    records = $table.bootstrapTable('getSelections');
    if(records.length < 1){
        alert("请选择至少一条数据！");
        return;
    }
    var idAr = [];
    //console.log(records);
    for(var i=0;i<records.length;i++){
        idAr.push(records[i].id);
    }
    //console.log(idAr);
    $.ajax({
        type:'post',
        traditional :true,
        url:baseURL+'/spider/crawler/start',
        data:{ids:idAr},
        success:function(data){
            if(data == '1'){
                alert("启动成功");
                $table.bootstrapTable('refresh');
            }else {
                alert("启动失败");
            }
        }
    });
}


function stop() {
    records = $table.bootstrapTable('getSelections');
    if(records.length < 1){
        alert("请选择至少一条数据！");
        return;
    }
    var idAr = [];
    //console.log(records);
    for(var i=0;i<records.length;i++){
        idAr.push(records[i].id);
    }
    //console.log(idAr);
    $.ajax({
        type:'post',
        traditional :true,
        url:baseURL+'/spider/crawler/stop',
        data:{ids:idAr},
        success:function(data){
            if(data == '1'){
                alert("停止成功");
                $table.bootstrapTable('refresh');
            }else {
                alert("停止失败");
            }
        }
    });
}


