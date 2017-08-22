/**
 * Created by user on 2017/7/7.
 */
/**
 * Created by cendechen on 2015/8/9.
 */
$(function () {
    function init() {
        var setting = {
            leftBarWidth: $(".leftbar").outerWidth(),
            topNavWidth: $(".header").height(),
            h: $(window).height(),
            w: $(window).width()
        };
        var containerW = setting.w - setting.leftBarWidth,
            containerH = setting.h - setting.topNavWidth;
        $(".container").height(containerH)
            .css("marginTop", setting.topNavWidth + "px")
            .css("marginLeft", setting.leftBarWidth + "px");
        $(".remark").width(setting.rightBarWidth);
        $(".draw-section").height(containerH).css("marginRight", setting.rightBarWidth + "px");
        $(".leftbar").height(containerH);
        $(".ndetail").height(containerH);
    }

    var i;

    function environment() {
        var navLeftTitle = $(".left-nav-title");
        $(".left-menu-hand-icon").on("click", function () {
            var iOpen = $(".left-menu").hasClass("left-menu-close");
            if (iOpen) {
                $(".left-menu").removeClass("left-menu-close");
                $(".left-menu-content").show();
                $(".container").removeClass("conactive")
            } else {
                $(".left-menu").addClass("left-menu-close");
                $(".left-menu-content").hide();
                $(".container").addClass("conactive")
            }
        });
        var url = location.pathname;
        var requestfilename = url.match(/\/([^\/]+)$/)[1].replace(".html", "");
        $("[data-target='" + requestfilename + "']").addClass("active");

    }

    environment();
    $(window).on("resize", function () {

    })
})