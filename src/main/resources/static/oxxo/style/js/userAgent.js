/**
 * Created by user on 2017/7/7.
 */
/**
 * Created by cendechen on 2015/10/14.
 */
(function(){
    var u, h;
    u = window.navigator.userAgent.toLowerCase();
    h = window.location;
    if(/AppleWebKit.*Mobile/i.test(u) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))) {
        //手机浏览器
        try {
            var p = h.pathname,l;
            if(l = p.match(/^\/map\/([a-zA-Z\-]*\.html)$/))
            {
                if (/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
                    window.location.href = "http://txwz.qq.com/map/m/"+l[1];
                }
            }
        } catch (e) {
        }
    }else{
        //PC浏览器
        try{
            var p = h.pathname,l;
            if(l = p.match(/^\/map\/m\/([a-zA-Z\-]*\.html)$/)){
                window.location.href = "http://txwz.qq.com/map/"+l[1];
            }
        }catch (e){

        }
    }
})()