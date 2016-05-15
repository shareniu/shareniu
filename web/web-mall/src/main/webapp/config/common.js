//用户pin\登录状态
var checkUserLoginState = function(cb) {
    if (typeof cb !== 'function' ) { return; }
    $.post(mdmall.base + '/common/isLogin.aj', function(r) {
        if (r.Identity) {
            cb(r.Identity);
        }
    });
};

var doLogin = function(baseUrl, afterFuntion) {
    checkUserLoginState(function(r) {
        if (!r.IsAuthenticated) {
            $.ajax({
                url: baseUrl + "/showLogin.html",
                async:false,
                type:"GET",
                success:function(data) {
                    if(data) {
                        var login_div = $('#login_div');
                        if (login_div.length == 0) {
                            $('body').append('<div id="login_div"></div>');
                        }
                        $('#login_div').html(data);
                    }
                }
            });
            loginSetting = function() {
                checkUserLoginState(function(r) {
                    if (!r.IsAuthenticated) {
                        if (getCookie("mallUser") != null) {
                            $("#headerUsername").text(r.Unick).show();
                        }
                        $("#cur_login_user").val("");
                        $(".no_login_li").show();
                        $(".has_login_li").hide();
                    } else {
                        if (r.Unick != null && r.Unick != "") {
                            $("#headerUsername").text(r.Unick).show();
                        } else {
                            $("#headerUsername").text(r.Name).show();
                        }
                        $("#cur_login_user").val(r.UserPin);
                        $(".has_login_li").show();
                        $(".no_login_li").hide();
                        afterFuntion();
                    }
                });
            };
        } else {
            afterFuntion();
        }
    });
};
// 添加Cookie
function addCookie(name, value, options) {
    if (arguments.length > 1 && name != null) {
        if (options == null) {
            options = {};
        }
        if (value == null) {
            options.expires = -1;
        }
        if (typeof options.expires == "number") {
            var time = options.expires;
            var expires = options.expires = new Date();
            expires.setTime(expires.getTime() + time * 1000);
        }
        document.cookie = encodeURIComponent(String(name)) + "=" + encodeURIComponent(String(value)) + (options.expires ? "; expires=" + options.expires.toUTCString() : "") + (options.path ? "; path=" + options.path : "") + (options.domain ? "; domain=" + options.domain : ""), (options.secure ? "; secure" : "");
    }
}

// 获取Cookie
function getCookie(name) {
    if (name != null) {
        var value = new RegExp("(?:^|; )" + encodeURIComponent(String(name)) + "=([^;]*)").exec(document.cookie);
        return value ? decodeURIComponent(value[1]) : null;
    }
}

// 移除Cookie
function removeCookie(name, options) {
    addCookie(name, null, options);
}