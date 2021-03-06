"use strict";
var _typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (n) {
    return typeof n
} : function (n) {
    return n && "function" == typeof Symbol && n.constructor === Symbol && n !== Symbol.prototype ? "symbol" : typeof n
};
!function (s, c) {
    location.protocol.substr(0, 4);
    var n = "1.6", e = {
        url: "https://g.csdnimg.cn/side-toolbar/" + n,
        opinion: {isShow: !1},
        qr: {
            isShow: !0,
            btnImgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/qr.png",
            data: [{
                imgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/qr_wechat.png",
                desc: "关注公众号"
            }, {imgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/qr_app.png", desc: "下载APP"}]
        },
        cs: {
            isShow: !0,
            btnImgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/kefu.png",
            clickUrl: "http://wpa.b.qq.com/cgi/wpa.php?ln=1&key=XzgwMDE4MDEwNl80ODc3MzVfODAwMTgwMTA2XzJf",
            clickFun: null
        },
        help: {
            isShow: !1,
            btnImgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/bangzhucopy.png",
            clickUrl: "",
            clickFun: null
        },
        report: {isShow: !1, btnImgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/jubaocopy.png"},
        goTop: {isShow: !0, btnImgSrc: "https://g.csdnimg.cn/side-toolbar/1.6/images/fanhuidingbucopy.png"},
        afterFinished: null
    }, t = {options: {}, goTop: y};
    void 0 === s.csdn && (s.csdn = {}), s.csdn.sideToolbar = Object.assign(t, s.csdn.sideToolbar);
    var o, i, a = s.csdn.sideToolbar.options;
    !function t(o, s) {
        Object.getOwnPropertyNames(o).forEach(function (n) {
            void 0 !== s[n] && ("object" === _typeof(s[n]) ? t(o[n], s[n]) : o[n] = s[n])
        }, null)
    }(e, a), o = e.url + "/side-toolbar.css", (i = c.createElement("link")).rel = "stylesheet", i.type = "text/css", i.href = o, c.getElementsByTagName("head")[0].appendChild(i);
    var r = "", l = "", p = "", d = "", g = "", b = "";
    if (e.opinion.isShow && (r = '\n    <a class="option-box" data-type="feedback">\n      <img src="' + e.opinion.btnImgSrc + '" alt="" srcset="">\n      <span class="show-txt">意见<br>反馈</span>\n    </a>\n    '), e.qr.isShow) {
        var h = "";
        e.qr.data.forEach(function (n) {
            h += '\n      <div class="qr-item-box">\n        <img src="' + n.imgSrc + '" alt="' + n.desc + '">\n        <p class="desc">' + n.desc + "</p>\n      </div>\n      "
        }), l = '\n    <a class="option-box" data-type="app">\n      <img src="' + e.qr.btnImgSrc + '" alt="" srcset="">\n      <span class="show-txt">手机看</span>\n      <div class="app-qr-box">\n        <div class="bg-box">\n          ' + h + "\n        </div>\n      </div>\n    </a>\n    "
    }
    e.cs.isShow && (p = '\n    <a class="option-box" data-type="cs">\n      <img src="' + e.cs.btnImgSrc + '" alt="" srcset="">\n      <span class="show-txt">客服</span>\n    </a>\n    '), e.help.isShow && (d = '\n    <a class="option-box" data-type="help">\n      <img src="' + e.help.btnImgSrc + '" alt="" srcset="">\n      <span class="show-txt">帮助</span>\n    </a>\n    '), e.report.isShow && (g = '\n    <a class="option-box" data-type="report">\n      <img src="' + e.report.btnImgSrc + '" alt="" srcset="">\n      <span class="show-txt">举报</span>\n    </a>\n    '), e.goTop.isShow && (b = '\n    <a class="option-box go-top-hide" data-type="gotop">\n      <img src="' + e.goTop.btnImgSrc + '" alt="" srcset="">\n      <span class="show-txt">返回<br>顶部</span>\n    </a>\n    ');
    var m = '\n  <div class="csdn-side-toolbar">\n    ' + r + "\n    " + l + "\n    " + p + "\n    " + d + "\n    " + g + "\n    " + b + "\n  </div>\n  ",
        u = c.createElement("div");

    function y() {
        var n = s.scrollY, t = n / 100, o = setInterval(function () {
            n -= t, s.scrollTo(0, n), n <= 0 && clearInterval(o)
        }, 10)
    }

    u.innerHTML = m, c.body.appendChild(u), null !== e.afterFinished && e.afterFinished(), c.body.onload = function () {
        if (e.goTop.isShow) {
            var n = function () {
                var n = s.scrollY;
                o <= n ? t.classList.remove("go-top-hide") : t.classList.add("go-top-hide")
            }, t = c.querySelector("a.option-box[data-type='gotop']"), o = s.outerHeight;
            c.body.scrollHeight;
            n(), s.addEventListener("scroll", n, !1), s.addEventListener("resize", function () {
                o = s.outerHeight, c.body.scrollHeight, n()
            }), t.addEventListener("click", y, !1)
        }
        e.cs.isShow && c.querySelector("a.option-box[data-type='cs']").addEventListener("click", function () {
            null !== e.cs.clickFun ? e.cs.clickFun() : s.open(e.cs.clickUrl, "_blank")
        }, !1);
        e.help.isShow && c.querySelector("a.option-box[data-type='cs']").addEventListener("click", function () {
            null !== e.help.clickFun ? e.help.clickFun() : s.open(e.help.clickUrl, "_blank")
        }, !1)
    }
}(window, document);