package ch.xch.androiddemo.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ch.xch.androiddemo.R;

public class WebViewActivity extends Activity {

    private WebView webView;
    private String data = "<!DOCTYPE html>\n" +
            "<html lang=\"en-US\" xmlns=\"http://www.w3.org/1999/html\">\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB2312\">\n" +
            "<title>节前上市 Moto X国行真机曝光</title>\n" +
            "<meta name=\"keywords\" content=\"节前上市 Moto X国行真机曝光,摩托罗拉MOTO X+1\">\n" +
            "<meta name=\"description\" content=\"摩托罗拉于1月7日宣布1月26日将推出Moto系列国行新品，包括MotoX、MotoG以及MotoXPro。现在MotoX国行的真机照片在\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width,  initial-scale=1.0, user-scalable=0, minimum-scale=1.0,  maximum-scale=1.0\">\n" +
            "<meta name=\"format-detection\" content=\"telephone=no\">\n" +
            "<!-- for apple -->\n" +
            "<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
            "<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
            "<meta content=\"black\" name=\"apple-mobile-web-app-status-bar-style\">\n" +
            "<!-- css -->\n" +
            "<link rel=\"stylesheet\" href=\"http://static.cnmo-img.com.cn/touch/app/css/index.css\">\n" +
            "<link rel=\"stylesheet\" href=\"http://static.cnmo-img.com.cn/touch/css/newstyle.css\">\n" +
            "<script type=\"text/javascript\" src=\"http://static.cnmo-img.com.cn/js/jquery144p.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"http://static.cnmo-img.com.cn/touch/js/TouchSlide.1.1.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"http://pic.cnmo-img.com.cn/oddjs/m/detail.js\"></script>\n" +
            "<script src=\"http://static.cnmo-img.com.cn/touch/js/common.js\"></script>\n" +
            "<link rel=\"stylesheet\" href=\"http://static.cnmo-img.com.cn/touch/uncle_spit/css/uncle.css\"> \n" +
            "</head>\n" +
            "\n" +
            "<!--[if IE]>\n" +
            "<script src=\"http://topic.cnmo.com/active/11/zt_topic_head/html5.js\"></script>\n" +
            "<![endif]-->\n" +
            "\n" +
            "<style>\n" +
            ".dateLeft i {\n" +
            "font-style: normal;\n" +
            "color: #6397cb;\n" +
            "display: inline-block;\n" +
            "padding-right: 16px;\n" +
            "background: url(http://icon.cnmo-img.com.cn/touch/info/p_bg.png) no-repeat right center;\n" +
            "background-size: 12px 12px;\n" +
            "}\n" +
            "\n" +
            ".comment_other{font-size:13px;text-align:right}\n" +
            ".comment_other span{margin-left:14px;display:inline-block;height:26px;line-height:26px;padding-left:18px;color:#999;background-image:url(http://icon.cnmo-img.com.cn/touch/info/comment_post.png);background-size:15px 100px;background-repeat:no-repeat}\n" +
            ".comment_other .sub1{background-position:0 5px}\n" +
            ".comment_other .sub2{background-position:0 -80px}\n" +
            ".comment_post{padding:10px;background:#F5F5F5;margin-top:6px;margin-bottom:-6px;display:none}\n" +
            ".comment_area{border:1px solid #E1E1E1;height:58px;background:#FFF}\n" +
            ".comment_area textarea{resize:none;border:none;width:100%;margin:4px 0;padding:0;height:50px;background:#FFF;font-size:16px}\n" +
            ".btn_replay{margin-top:10px}\n" +
            ".btn_replay a{display:block;height:40px;line-height:40px;background:#3398CC;text-align:center;color:#FFF;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}\n" +
            "\n" +
            "</style>\n" +
            "<body>\n" +
            "\n" +
            "<input type=\"hidden\"  id=\"address\" value=\"手机中国四川网友\" />\n" +
            "<input type=\"hidden\"  id=\"articleId\" value=\"468398\"/>\n" +
            "<input type=\"hidden\"  id=\"lastCommentId\" value=\"252921\" />\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "function trim(str)\n" +
            "{ //删除左右两端的空格\n" +
            "    return str.replace(/(^\\s*)|(\\s*$)/g, \"\");\n" +
            "}\n" +
            "\n" +
            "function filterBlank(content)\n" +
            "{\n" +
            "\treturn trim(content);\n" +
            "}\n" +
            "\n" +
            "function filterScript(content)\n" +
            "{\n" +
            "\tcontent = content.replace(/</g, \"&lt;\");\n" +
            "\tcontent = content.replace(/>/g, \"&gt;\");\n" +
            "\n" +
            "\treturn content;\n" +
            "}\n" +
            "    /**\n" +
            "     * 插入一条新的评论以后，将评论插入所有评论头部\n" +
            "     */\n" +
            "    function insertComment(uname, content, commentid)\n" +
            "    {\n" +
            "    \t\n" +
            "        var handler = document.getElementById(\"comments\");\n" +
            "        var address = document.getElementById(\"address\").value;\n" +
            "        var objid = 468398;\n" +
            "\n" +
            "        content = filterScript(content);\n" +
            "        if(uname && uname.length!=0){\n" +
            "        \tvar nickname = uname;\n" +
            "        }else{\n" +
            "        \tvar nickname =  address;\n" +
            "        }\n" +
            "\n" +
            "        nickname = $(\"#address\").val();\n" +
            "\t\t\n" +
            "        var commentDiv = \"\\\n" +
            "       \t \t<div class='commnetoDiv'>\\\n" +
            "   \t\t \t\t<header class='c1Tit'>\\\n" +
            "   \t\t \t\t\t<span class='r'>\" + nickname + \"</span>\\\n" +
            "   \t\t \t\t\t<span class='rightDate'>刚刚</span>\\\n" +
            "   \t\t\t \t</header>\\\n" +
            "    \t\t\t<article class='commentTxt-p'>\\\n" +
            "        \t\t\t<p>\" + content + \"</p>\" + \n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t// new include\n" +
            "        \t\t\t'<div class=\"comment_other\">' + \n" +
            "\t\t\t\t\t'<span class=\"sub1\" style=\"cursor:pointer;\" onclick=\"vote(this,' + commentid + \", 1, '手机中国四川网友',\" + objid + ', 2)\">0</span>' +\n" +
            "\t\t\t\t\t'<span class=\"sub2\" onclick=\"showReplay(this,' + commentid + ',' + objid + \",'\" + address + \"'\" + ')\"<font id=\"replyCount_' + commentid + '\">0</font></span>' +\n" +
            "\t\t\t\t'</div>' +\n" +
            "\t\t\t\t'<div class=\"comment_post\">' +\n" +
            "\t\t\t\t\t\t'<div>' +\n" +
            "\t\t\t\t\t\t'<div class=\"comment_area\"><textarea class=\"replycomment\" name=\"\" placeholder=\"回复@手机中国四川网友\"></textarea></div>' +\n" +
            "\t\t\t\t\t\t'<div class=\"btn_replay\">' +\n" +
            "\t\t\t\t\t\t\t'<a href=\"javascript:;\" onclick=\"addReplyComment(this,' + objid + ',' + commentid + \",'\" + address + \"'\" + ');\">发表评论</a>' +\n" +
            "\t\t\t\t\t\t'</div>' +\n" +
            "\t\t\t\t\t'</div>' + \t\n" +
            "\t\t\t\t\t'<font id=\"replyComments_' + commentid + '\"></font>' +\n" +
            "\t\t\t\t'</div>' +\n" +
            "\t\t\t\t// new include\n" +
            "        \t\t\t\n" +
            "        \t\t\t\n" +
            "    \t\t\t\"</article>\" +\n" +
            "\t\t\t\"</div>\";\n" +
            "\n" +
            "        handler.innerHTML = commentDiv + handler.innerHTML;\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * 插入回复的评论\n" +
            "     */\n" +
            "    function insertReplyComment(nname, uname, content)\n" +
            "    {\n" +
            "\n" +
            "    \tvar address = document.getElementById(\"address\").value;\n" +
            "\n" +
            "        content = filterScript(content);\n" +
            "        if(uname && uname.length!=0){\n" +
            "        \tvar nickname = uname;\n" +
            "        }else{\n" +
            "        \tvar nickname = '手机中国' + address + '网友';\n" +
            "        }\n" +
            "        \n" +
            "    \tvar replyStr = '<div class=\"commnetoDiv\">\\\n" +
            "\t\t\t\t\t\t\t<header class=\"c1Tit\"><span class=\"r\">'+nickname+'@'+nname+'</span><span class=\"rightDate\">刚刚</span></header>\\\n" +
            "\t\t\t\t\t\t\t<article class=\"commentTxt-p\">\\\n" +
            "\t\t\t\t\t\t\t\t<p>'+content+'</p>\\\n" +
            "\t\t\t\t\t\t\t</article>\\\n" +
            "\t\t\t\t\t\t</div>';\n" +
            "\n" +
            "\t\t$('.comment_lou').append(replyStr);\n" +
            "    }\n" +
            "\n" +
            "    function displayMoreCommentsBar()\n" +
            "    {\n" +
            "        document.getElementById(\"lookCommentsMore\").style.display = \"block\";\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * 当添加完一条评论后将评论总数加1\n" +
            "     */\n" +
            "    function addCommentsTotal()\n" +
            "    {\n" +
            "    \tvar commentsTotal = document.getElementsByName(\"commentsTotal\");\n" +
            "    \t\n" +
            "\t\tfor(var i = 0; i < commentsTotal.length; ++i)\n" +
            "\t\t{\n" +
            "\t\t\tif(commentsTotal[i].innerHTML == \"抢沙发\")\n" +
            "\t\t\t{\n" +
            "\t\t\t\tcommentsTotal[i].innerHTML = 1;\n" +
            "\t\t\t}\n" +
            "\t\t\telse\n" +
            "\t\t\t{\n" +
            "\t\t\t\tvar total = parseInt(commentsTotal[i].innerHTML) + 1;\n" +
            "\t\t\n" +
            "\t\t\t\tcommentsTotal[i].innerHTML = total;\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "    }\n" +
            "\n" +
            "    var addAjax = undefined;\n" +
            "\n" +
            "    function insertAReplyComment(replyid, content, nickname)\n" +
            "    {\n" +
            "\t\tstr = '<div class=\"comment_lou\"> \\\n" +
            "\t\t\t<div class=\"commnetoDiv\" style=\"display:block\">' + \n" +
            "\t\t\t\t'<header class=\"c1Tit\"><span class=\"r\">手机中国四川网友@' + nickname + \n" +
            "\t\t\t\t'</span><span class=\"rightDate\">' + '刚刚' + '</span></header> \\\n" +
            "\t\t\t\t<article class=\"commentTxt-p\">\\\n" +
            "\t\t\t\t<p>'+  content + '</p>\\\n" +
            "\t\t\t\t</article>\\\n" +
            "\t\t\t</div>\\\n" +
            "\t\t</div>';\n" +
            "\n" +
            "\t\t$(\"#replyComments_\" + replyid).html(str + $(\"#replyComments_\" + replyid).html());\n" +
            "    }\n" +
            "    var replyAjax = undefined;\n" +
            "    \n" +
            "\tfunction addReplyComment(obj, docid, replyid, nickname)\n" +
            "\t{\n" +
            "        var content = $(obj).parent().parent().find('.comment_area').find('textarea').val();\n" +
            "        content = filterBlank(content);\n" +
            "        content = filterScript(content);\n" +
            "\n" +
            "        if(\"\" == content)\n" +
            "        {\n" +
            "            alert(\"评论内容不能为空!!\");\n" +
            "            $('.replycomment').focus();\n" +
            "            return ;\n" +
            "        }\n" +
            "        \n" +
            "\t\tif(undefined != replyAjax)\n" +
            "\t\t{\n" +
            "\t\t\talert(\"亲，发表评论过于频繁，请稍后再发表！！！\");\n" +
            "\t\t\treturn ;\n" +
            "\t\t}\n" +
            "        var url = \"index.php?c=CommentAjax&m=AddReplyComment\";\n" +
            "        var ajaxJson = {articleId: docid, replyid: replyid, content: content};\n" +
            "\t\treplyAjax = $.post(url, ajaxJson, function (data)\n" +
            "\t\t{\n" +
            "\t\t\tvar count = parseInt($(\"#replyCount_\" + replyid).html());\n" +
            "\t\t\t$(\"#replyCount_\" + replyid).html(count + 1);\n" +
            "\t\t\tinsertAReplyComment(replyid, content, nickname);\n" +
            "\t\t\treplyAjax = undefined;\n" +
            "\t\t});\n" +
            "\n" +
            "        $(obj).parent().parent().find('.comment_area').find('textarea').val('');        \n" +
            "\t}\n" +
            "\n" +
            "    /**\n" +
            "     * 添加一条心的评论数据\n" +
            "     */\n" +
            "    function addComment()\n" +
            "    {\n" +
            "        var classname = $('#classname').val();\n" +
            "        //var baseUrl = 'http://wwwtest.cnmo.com/touch/html/' + classname + '/'; \n" +
            "        var url = \"index.php?c=CommentAjax&m=AddNewComment\";\n" +
            "        var articleId = document.getElementById(\"articleId\").value;\n" +
            "        var content = document.getElementById(\"commentContent\").value;\n" +
            "\t\t\n" +
            "        content = filterBlank(content);\n" +
            "\t\t\n" +
            "        if(\"\" == content)\n" +
            "        {\n" +
            "            alert(\"评论内容不能为空!!\");\n" +
            "            document.getElementById(\"commentContent\").focus();\n" +
            "            return ;\n" +
            "        }\n" +
            "\n" +
            "        if(undefined != addAjax)\n" +
            "        {\n" +
            "            alert(\"发表评论过于频繁！！！\");\n" +
            "            return ;\n" +
            "        }\n" +
            "\n" +
            "        var sendJson =\n" +
            "        {\n" +
            "            articleId: articleId,\n" +
            "            content: content,\n" +
            "            channel: 'news'\n" +
            "        };\n" +
            "\n" +
            "        addAjax = $.post(url, sendJson, function (data)\n" +
            "        {\n" +
            "            insertComment(data.nickname, content, data);\n" +
            "            addCommentsTotal();\n" +
            "            displayMoreCommentsBar();\n" +
            "\n" +
            "            // 允许提交评论\n" +
            "            addAjax = undefined;\n" +
            "        }, \"json\");\n" +
            "\n" +
            "        // 清空输入框中的内容\n" +
            "        document.getElementById(\"commentContent\").value = \"\";\n" +
            "    }\n" +
            "</script>\n" +
            "<!--头部-->\n" +
            "<!--header-->\n" +
            "<script src=\"http://static.cnmo-img.com.cn/touch/js/common.js\"></script>\n" +
            "<!--头部-->\n" +
            "<!--header-->\n" +
            "<section class=\"bg-head clearfix bgHead-fixed\">\n" +
            "    <a href=\"javascript:void(0);\"  class=\"r_nav_hover\" ></a>\n" +
            "    <nav class=\"r_nav_con\" id=\"nav_con\">\n" +
            "        <span><a class=\"o1\" href=\"http://m.cnmo.com/news/\">资讯中心</a></span>\n" +
            "        <span><a class=\"o2n\" href=\"http://m.cnmo.com/fashion/c9_s73.html\">手机时尚</a></span>\n" +
            "        <span><a class=\"o3\" href=\"http://m.cnmo.com/product/mobile/all/product.html\">手机大全</a></span>\n" +
            "        <span><a class=\"o4n\" href=\"http://m.cnmo.com/app/\">手机应用</a></span>\n" +
            "    </nav>\n" +
            "    <a href=\"http://m.cnmo.com\" class=\"logo\" onFocus=\"this.blur()\">手机中国</a>\n" +
            "    <span class=\"ge\"></span>\n" +
            "    <h1 class=\"tit-h1\">\n" +
            "        <span id=\"colwite\" class=\"newsTitle\">\n" +
            "        <a href=\"http://m.cnmo.com/news/\">资讯</a><em>></em><a href=\"http://m.cnmo.com/news/\">新闻</a>\n" +
            "        </span>\n" +
            "    </h1>\n" +
            "</section>\n" +
            "<!--导航-->\n" +
            "<!-- 公用导航 -->\n" +
            "<script>\n" +
            "// 头部导航缓动显示与隐藏\n" +
            "$(function(){\n" +
            "    $(\".r_nav_hover\").click(function(){\n" +
            "            if ($(\"#nav_con\").css(\"display\") == \"none\") {\n" +
            "                $(\"#nav_con\").css(\"display\",\"block\");\n" +
            "            } else if ($(\"#nav_con\").css(\"display\") == \"block\") {\n" +
            "                $(\"#nav_con\").css(\"display\", \"none\");\n" +
            "            }\n" +
            "        }\n" +
            "    )\n" +
            "});\n" +
            "</script><!--导航-->\n" +
            "<!-- 公用导航 -->\n" +
            "<section class=\"Main-index bgHead-fixed-mt\">\n" +
            "    <h2 class=\"h2Tit\">节前上市 Moto X国行真机曝光</h2>\n" +
            "    <div class=\"DateoDiv\">\n" +
            "        <a href=\"#commentsArea\" class=\"dateRight\"><font name=\"commentsTotal\">18</font><em class=\"emico\"></em></a>\n" +
            "        <span class=\"dateLeft\"><label>2015-01-09 14:10:43</label><label class=\"date-names\">沈唱唱</label><i>2</i></span>\n" +
            "    <div class=\"TxtPic\">\n" +
            "        \n" +
            "\n" +
            "\n" +
            "\n" +
            "<P>　　【<a href=\"http://m.cnmo.com/\" class=\"key_word\">手机</a>中国 新闻】<a href=\"http://m.cnmo.com/product/mobile/pro_sub_manu/sub_57_manu_295_1.shtml\" class=\"key_word\">摩托罗拉</a>于1月7日宣布1月26日将推出Moto系列国行新品，包括Moto X、Moto G以及Moto X Pro。现在Moto X国行的真机照片在网上遭到曝光，其系统保持原生<a href=\"http://m.cnmo.com/app/android/\" class=\"key_word\">Android</a> 5.0 Lollipop操作系统的体验。</P>\n" +
            "<P align=center><a href=\"http://m.cnmo.com/news/468398_1179995.html\"><IMG style=\"BORDER-TOP: black 1px solid; BORDER-RIGHT: black 1px solid; BORDER-BOTTOM: black 1px solid; BORDER-LEFT: black 1px solid\" alt=\"Moto X国行真机曝光 搭载联想应用商店 \" src=\"http://img.cnmo-img.com.cn/1180_600x375/1179995.jpg\"></a><BR>Moto X国行真机</P>\n" +
            "<P>　　消息称，Moto X国行没有Google Play应用商店，不过将预装<a href=\"http://m.cnmo.com/product/mobile/pro_sub_manu/sub_57_manu_1763_1.shtml\" class=\"key_word\">联想</a>应用商店，除此之外国行版还将内置茄子快传、<a href=\"http://m.cnmo.com/app/android/160016/\" class=\"key_word\">灵犀</a>语音助手等应用，在本土化方面做出改进。</P>\n" +
            "<P>　　此外Moto X Pro这款产品实际上是增加了Moto Action、Moto Voice以及Moto Display功能的Nexus 6原型机。</P>\n" +
            "<P align=center><a href=\"http://m.cnmo.com/news/468398_1179993.html\"><IMG style=\"BORDER-TOP: black 1px solid; BORDER-RIGHT: black 1px solid; BORDER-BOTTOM: black 1px solid; BORDER-LEFT: black 1px solid\" alt=\"Moto X国行真机曝光 搭载联想应用商店 \" src=\"http://img.cnmo-img.com.cn/1180_500x375/1179993.jpg\"></a><BR>Moto X国行真机</P>\n" +
            "<P>　　摩托罗拉此前曾表示，Moto X国行会在2月初（春节前）在中国大陆地区上市，Moto G与Moto X Pro上市时间在今年3月份，而Moto X最终的款式将由中国用户投票决定。不过目前三款新机的价格信息并未公布。</P>    </div>\n" +
            "    <div class=\"loading-div\" style=\"display:none\"><label></label><span>正在加载更多</span></div>\n" +
            "        <div id=\"loader\"></div>\n" +
            "    <div class=\"Share\">\n" +
            "        分享到：\n" +
            "        <span>\n" +
            "            <a href=\"http://service.weibo.com/share/share.php?url=http%3A%2F%2Fm.cnmo.com%2Fnews%2F468398.html%3Fuc_param_str%3Dcpdnvefrpfssntbi&title=%BD%DA%C7%B0%C9%CF%CA%D0+Moto+X%B9%FA%D0%D0%D5%E6%BB%FA%C6%D8%B9%E2&searchPic=false&appkey=1387762139&pic=http://img.cnmo-img.com.cn/1181_160x120/1180032.jpg&refer=http%3A%2F%2Fm.cnmo.com%2Fnews%2F468398.html%3Fuc_param_str%3Dcpdnvefrpfssntbi\"><img src=\"http://icon.cnmo-img.com.cn/touch/info/weibo.jpg\"></a>\n" +
            "            <a href=\"http://share.v.t.qq.com/index.php?c=share&a=index&url=http%3A%2F%2Fm.cnmo.com%2Fnews%2F468398.html%3Fuc_param_str%3Dcpdnvefrpfssntbi&title=%BD%DA%C7%B0%C9%CF%CA%D0+Moto+X%B9%FA%D0%D0%D5%E6%BB%FA%C6%D8%B9%E2&appkey=801209640&pic=http://img.cnmo-img.com.cn/1181_160x120/1180032.jpg\"><img src=\"http://icon.cnmo-img.com.cn/touch/info/qqweibo.jpg\"></a>\n" +
            "            <a href=\"http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http%3A%2F%2Fm.cnmo.com%2Fnews%2F468398.html%3Fuc_param_str%3Dcpdnvefrpfssntbi&desc=%BD%DA%C7%B0%C9%CF%CA%D0+Moto+X%B9%FA%D0%D0%D5%E6%BB%FA%C6%D8%B9%E2&pic=http://img.cnmo-img.com.cn/1181_160x120/1180032.jpg\"><img src=\"http://icon.cnmo-img.com.cn/touch/info/qzone.jpg\"></a>\n" +
            "        </span>\n" +
            "    </div>\n" +
            "    <!--广告位-->\n" +
            "    <div class=\"TxtPic-img2\"><script>write_ad(\"touch_doc_page_bottom_tonglan1\")</script></a></div>\n" +
            "    <!--end 广告位-->\n" +
            "        <div class=\"downoDiv\">\n" +
            "        <a href=\"http://m.cnmo.com/product/mobile/cell_phone/index1621609.shtml\"><h3>摩托罗拉MOTO X+1</h3></a>  \n" +
            "        <div class=\"\">\n" +
            "            <div class=\"claimListwi clearfix\">\n" +
            "                <div class=\"iphoneLeft\">\n" +
            "                \t<a href=\"http://m.cnmo.com/product/mobile/cell_phone/index1621609.shtml\">\n" +
            "                    <img src=\"http://imgm.cnmo-img.com.cn/product_erect/160x120/1622/1621609.jpg\" alt=\"摩托罗拉MOTO X+1\" height=\"60\" onerror=\"javascript:this.src='http://icon.cnmo-img.com.cn/product/noimg160x120.jpg';\">\n" +
            "\t\t\t\t\t</a>               \n" +
            "                </div>\n" +
            "                <div class=\"iphoneRight\">\n" +
            "                    <span>参考价格：<font color=\"#cc0000\">即将上市</font></span>\n" +
            "                    <span>上市时间：2014-05</span>\n" +
            "                    <span class=\"\">\n" +
            "                    <a href=\"http://m.cnmo.com/product/mobile/cell_phone/index1621609.shtml\">综述</a><a href=\"http://m.cnmo.com/product/mobile/1622/1621609/param.shtml\">参数</a><a href=\"http://m.cnmo.com/product/mobile/1622/1621609/dianping.shtml\">点评</a>\n" +
            "                    </span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "        <!--应用区块-->\n" +
            "    </section>\n" +
            "<section>\n" +
            "            <!--相关新闻-->\n" +
            "        <div class=\"NewsoDiv-xg\">\n" +
            "            <div class=\"NewsoDiv-xg-tit\">\n" +
            "                <a href=\"http://m.cnmo.com/news/\">更多<label>&gt;&gt;</label></a><span>相关新闻</span>\n" +
            "            </div>\n" +
            "            <ul class=\"listUl\">\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/402870.html\">1080p屏 Moto X+1或于本月登场</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/401166.html\">1080p超大屏 Moto X+1谍照现身</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/394264.html\">智能新机 Moto X+1或7月登场</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/378239.html\">经典升级版 Moto X+1即将上市</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/430919.html\">超强配置 DROID Turbo遭曝光</a></li>\n" +
            "                            </ul>\n" +
            "        </div>\n" +
            "        <!--end 相关新闻-->\n" +
            "        <!--热门资讯-->\n" +
            "            <div class=\"NewsoDiv-xg mt15\">\n" +
            "            <div class=\"NewsoDiv-xg-tit\">\n" +
            "                <!--<a href=\"\">更多<label>&gt;&gt;</label></a>--><span>热门资讯</span>\n" +
            "            </div>\n" +
            "            <ul class=\"listUl\">\n" +
            "                                    <li><a href=\"http://m.cnmo.com/reviews/462522.html\">八核双镜头华为荣耀6 Plus评测</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/reviews/464317.html\">没贵多少但好不少 魅蓝note评测</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/466435.html\">699元双4G 红米手机2正式发布</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/466004.html\">1月亮相 疑似黑色版小米5曝光</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/462529.html\">双镜头荣耀6 Plus拍照样张赏析</a></li>\n" +
            "                            </ul >\n" +
            "        </div>\n" +
            "        <!--end 热门资讯-->\n" +
            "    <!--网友评论-->\n" +
            "    <div class=\"NewsoDiv-xg mt15\" id=\"commentsArea\">\n" +
            "        <div class=\"NewsoDiv-xg-tit  news_t\">\n" +
            "            <span>网友评论</span>\n" +
            "            <div class=\"m_login\"  id=\"user_login\"><a href=\"http://passport.m.cnmo.com/register/\">注册</a><i>|</i><a href=\"http://passport.m.cnmo.com/login/\">登录</a></div>\n" +
            "        </div>\n" +
            "        <div class=\"textoDiv\">\n" +
            "            <p>\n" +
            "                <textarea class=\"textarea-txt\" id=\"commentContent\"></textarea>\n" +
            "            </p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <!--end 网友评论-->\n" +
            "    <!--发表评论-->\n" +
            "    <section class=\"btn5 Bntosection\">\n" +
            "        <a href=\"javascript:;\" onclick=\"addComment();\"><span id=\"postIdTip\"><i></i>发表评论</span></a>\n" +
            "    </section>\n" +
            "    <!--end 发表评论-->\n" +
            "    <section class=\"CommentTxt\" id=\"comments\">\n" +
            "                    <div class=\"commnetoDiv\">\n" +
            "                <header class=\"c1Tit\"><span class=\"r\">手机中国网友</span><span class=\"rightDate\">1小时前</span></header>\n" +
            "                <article class=\"commentTxt-p\">\n" +
            "                    <p>目测联想要毁moto了</p>\n" +
            "                                        <div class=\"comment_other\">\n" +
            "\t\t\t\t\t\t<span class=\"sub1\" style=\"cursor:pointer;\" onclick=\"vote(this,253128,1,'手机中国网友',468398,0)\">0</span>\n" +
            "\t\t\t\t\t\t<span class=\"sub2\" onclick=\"showReplay(this,253128,468398, '手机中国网友');\"><font id=\"replyCount_253128\">0</font></span>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"comment_post\">\n" +
            "\t\t\t\t\t\t<div>\n" +
            "\t\t\t\t\t\t\t<div class=\"comment_area\"><textarea class=\"replycomment\" name=\"\" placeholder=\"回复@手机中国网友\"></textarea></div>\n" +
            "\t\t\t\t\t\t\t<div class=\"btn_replay\">\n" +
            "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" onclick=\"addReplyComment(this, 468398,253128, '手机中国网友');\">发表评论</a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<!-- http://comments.cnmo.com/include/ajax/ajax_vote.php?comment_id=197696&type=1&articleid=428149&user=shoujikong2012&kindid=2&rt=0.06611391925252974 -->\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<font id=\"replyComments_253128\"></font>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<!-- 盖楼end -->\n" +
            "                </article>\n" +
            "            </div>\n" +
            "                    <div class=\"commnetoDiv\">\n" +
            "                <header class=\"c1Tit\"><span class=\"r\">手机中国网友</span><span class=\"rightDate\">5小时前</span></header>\n" +
            "                <article class=\"commentTxt-p\">\n" +
            "                    <p>楼下好多嘴炮，不买就不买，还装逼找理由。</p>\n" +
            "                                        <div class=\"comment_other\">\n" +
            "\t\t\t\t\t\t<span class=\"sub1\" style=\"cursor:pointer;\" onclick=\"vote(this,253043,1,'手机中国网友',468398,0)\">1</span>\n" +
            "\t\t\t\t\t\t<span class=\"sub2\" onclick=\"showReplay(this,253043,468398, '手机中国网友');\"><font id=\"replyCount_253043\">0</font></span>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"comment_post\">\n" +
            "\t\t\t\t\t\t<div>\n" +
            "\t\t\t\t\t\t\t<div class=\"comment_area\"><textarea class=\"replycomment\" name=\"\" placeholder=\"回复@手机中国网友\"></textarea></div>\n" +
            "\t\t\t\t\t\t\t<div class=\"btn_replay\">\n" +
            "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" onclick=\"addReplyComment(this, 468398,253043, '手机中国网友');\">发表评论</a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<!-- http://comments.cnmo.com/include/ajax/ajax_vote.php?comment_id=197696&type=1&articleid=428149&user=shoujikong2012&kindid=2&rt=0.06611391925252974 -->\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<font id=\"replyComments_253043\"></font>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<!-- 盖楼end -->\n" +
            "                </article>\n" +
            "            </div>\n" +
            "                    <div class=\"commnetoDiv\">\n" +
            "                <header class=\"c1Tit\"><span class=\"r\">手机中国网友</span><span class=\"rightDate\">5小时前</span></header>\n" +
            "                <article class=\"commentTxt-p\">\n" +
            "                    <p>真漂亮</p>\n" +
            "                                        <div class=\"comment_other\">\n" +
            "\t\t\t\t\t\t<span class=\"sub1\" style=\"cursor:pointer;\" onclick=\"vote(this,253000,1,'手机中国网友',468398,0)\">0</span>\n" +
            "\t\t\t\t\t\t<span class=\"sub2\" onclick=\"showReplay(this,253000,468398, '手机中国网友');\"><font id=\"replyCount_253000\">0</font></span>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"comment_post\">\n" +
            "\t\t\t\t\t\t<div>\n" +
            "\t\t\t\t\t\t\t<div class=\"comment_area\"><textarea class=\"replycomment\" name=\"\" placeholder=\"回复@手机中国网友\"></textarea></div>\n" +
            "\t\t\t\t\t\t\t<div class=\"btn_replay\">\n" +
            "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" onclick=\"addReplyComment(this, 468398,253000, '手机中国网友');\">发表评论</a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<!-- http://comments.cnmo.com/include/ajax/ajax_vote.php?comment_id=197696&type=1&articleid=428149&user=shoujikong2012&kindid=2&rt=0.06611391925252974 -->\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<font id=\"replyComments_253000\"></font>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<!-- 盖楼end -->\n" +
            "                </article>\n" +
            "            </div>\n" +
            "                    <div class=\"commnetoDiv\">\n" +
            "                <header class=\"c1Tit\"><span class=\"r\">手机中国网友</span><span class=\"rightDate\">5小时前</span></header>\n" +
            "                <article class=\"commentTxt-p\">\n" +
            "                    <p>真漂亮</p>\n" +
            "                                        <div class=\"comment_other\">\n" +
            "\t\t\t\t\t\t<span class=\"sub1\" style=\"cursor:pointer;\" onclick=\"vote(this,252955,1,'手机中国网友',468398,0)\">0</span>\n" +
            "\t\t\t\t\t\t<span class=\"sub2\" onclick=\"showReplay(this,252955,468398, '手机中国网友');\"><font id=\"replyCount_252955\">0</font></span>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"comment_post\">\n" +
            "\t\t\t\t\t\t<div>\n" +
            "\t\t\t\t\t\t\t<div class=\"comment_area\"><textarea class=\"replycomment\" name=\"\" placeholder=\"回复@手机中国网友\"></textarea></div>\n" +
            "\t\t\t\t\t\t\t<div class=\"btn_replay\">\n" +
            "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" onclick=\"addReplyComment(this, 468398,252955, '手机中国网友');\">发表评论</a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<!-- http://comments.cnmo.com/include/ajax/ajax_vote.php?comment_id=197696&type=1&articleid=428149&user=shoujikong2012&kindid=2&rt=0.06611391925252974 -->\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<font id=\"replyComments_252955\"></font>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<!-- 盖楼end -->\n" +
            "                </article>\n" +
            "            </div>\n" +
            "                    <div class=\"commnetoDiv\">\n" +
            "                <header class=\"c1Tit\"><span class=\"r\">手机中国网友</span><span class=\"rightDate\">5小时前</span></header>\n" +
            "                <article class=\"commentTxt-p\">\n" +
            "                    <p>手机价格定位不应超过HTC，估计还有戏！如果想定位高大上，大赚一笔！那是找死！两年前摩托罗拉手机卖不动，自己憋死了！</p>\n" +
            "                                        <div class=\"comment_other\">\n" +
            "\t\t\t\t\t\t<span class=\"sub1\" style=\"cursor:pointer;\" onclick=\"vote(this,252921,1,'手机中国网友',468398,0)\">0</span>\n" +
            "\t\t\t\t\t\t<span class=\"sub2\" onclick=\"showReplay(this,252921,468398, '手机中国网友');\"><font id=\"replyCount_252921\">0</font></span>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"comment_post\">\n" +
            "\t\t\t\t\t\t<div>\n" +
            "\t\t\t\t\t\t\t<div class=\"comment_area\"><textarea class=\"replycomment\" name=\"\" placeholder=\"回复@手机中国网友\"></textarea></div>\n" +
            "\t\t\t\t\t\t\t<div class=\"btn_replay\">\n" +
            "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" onclick=\"addReplyComment(this, 468398,252921, '手机中国网友');\">发表评论</a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<!-- http://comments.cnmo.com/include/ajax/ajax_vote.php?comment_id=197696&type=1&articleid=428149&user=shoujikong2012&kindid=2&rt=0.06611391925252974 -->\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<font id=\"replyComments_252921\"></font>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<!-- 盖楼end -->\n" +
            "                </article>\n" +
            "            </div>\n" +
            "            </section>\n" +
            "    <!--发表评论-->\n" +
            "    <section class=\"btn5 Bntosection Bnt-more\" id=\"lookCommentsMore\" >\n" +
            "        <a href=\"index.php?c=CommentsDetail&m=Index&documentId=468398\"><span id=\"postIdTip\"><i></i>查看18条评论</span></a>\n" +
            "    </section>\n" +
            "    <!--end 发表评论-->\n" +
            "            <!--新闻推荐-->\n" +
            "        <div class=\"NewsoDiv-xg news-tuijian\">\n" +
            "            <div class=\"NewsoDiv-xg-tit\">\n" +
            "                <span>新闻推荐</span>\n" +
            "            </div>\n" +
            "            <ul class=\"listUl\">\n" +
            "                                    <li><a href=\"http://m.cnmo.com/pad/468369.html\">小米平板电脑将登陆马来西亚</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/pad/468353.html\">或Q2发布 疑iPad Pro模具曝光</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/468417.html\">贾跃亭：乐视手机“颜值爆表”</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/news/468398.html\">节前上市 Moto X国行真机曝光</a></li>\n" +
            "                                    <li><a href=\"http://m.cnmo.com/pad/468405.html\">2万台诺基亚N1平板4分2秒售罄</a></li>\n" +
            "                            </ul>\n" +
            "        </div>\n" +
            "        <!--end 新闻推荐-->\n" +
            "    <!--底部导航-->\n" +
            "    <input type=\"hidden\" id=\"classname\" value=\"news\" />\n" +
            "    <div class=\"footNav mt10\">\n" +
            "    <ul class=\"clearfix\">\n" +
            "        <li><a class=\"footNav-1\" href=\"http://m.cnmo.com\">首页</a></li>\n" +
            "        <li><a class=\"footNav-2-t\" href=\"http://m.cnmo.com/news/\">新闻</a><a class=\"footNav-2-b\" href=\"http://m.cnmo.com/product/mobile/all/product.html\">手机大全</a></li>\n" +
            "        <li><a class=\"footNav-3-t\" href=\"http://m.cnmo.com/reviews/\">评测</a><a class=\"footNav-3-b\" href=\"http://m.cnmo.com/tu/c8.html\">数码漫谈</a></li>\n" +
            "        <li><a class=\"footNav-4-t\" href=\"http://m.cnmo.com/app/\">下载</a><a class=\"footNav-4-b\" href=\"http://m.cnmo.com/tu/c1.html\">手机美图</a></li>\n" +
            "    </ul>\n" +
            "</div>    <!--end 底部导航-->\n" +
            "</section>\n" +
            "<!--返回顶部-->\n" +
            "<div id=\"to_top\" style=\"display: none;\"><a href=\"javascript:;\"></a></div>\n" +
            "<!--end 返回顶部-->\n" +
            "<!--底部-->\n" +
            "<script>\n" +
            "new Image().src='http://pvsite.cnmo.com/images/at001.gif?type=m_article_pv&objid=468398'+'&r='+Math.random();\n" +
            "</script>\n" +
            "<!--footer(公用)-->\n" +
            "<footer class=\"footer footer-Article\">\n" +
            "    <div class=\"centerbox clearfix\">\n" +
            "        <a id=\"touchUrl\" href=\"http://m.cnmo.com/news/468398.html?uc_param_str=cpdnvefrpfssntbi\" class=\"cur\">触屏版</a>\n" +
            "        <a id=\"pcUrl\" href=\"http://www.cnmo.com/news/468398.html\">电脑版</a>\n" +
            "    </div>\n" +
            "<script language=\"JavaScript\" type=\"text/javascript\" src=\"http://js.cnmo.com/pv.js\"></script>\n" +
            "    <script language=\"JavaScript\" src=\"http://stat.cnmo.com/ol_cnmo.js\" type=\"text/javascript\"></script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\n" +
            "        document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3F04fab3def376a222f35762aa47e96232' type='text/javascript'%3E%3C/script%3E\"));\n" +
            "        // 电脑版跳转\n" +
            "        $(\"#pcUrl\").click(function(){\n" +
            "            writeCookie('isJumpTo', '1', 24);\n" +
            "        });\n" +
            "    </script>\n" +
            "</footer><!--底部-->\n" +
            "<!--end 返回顶部-->\n" +
            "<script language=\"javascript\">\n" +
            "        var docArr = new Array();\n" +
            "        docArr = [468398];\n" +
            "        var o = docArr.indexOf(468398);\n" +
            "        var h = $(window).height();\n" +
            "        var classname = $('#classname').val();\n" +
            "        //var baseUrl = 'http://wwwtest.cnmo.com/touch/html/' + classname + '/';\n" +
            "        function loadoc(){\n" +
            "            var j = o+1;\n" +
            "            $.get(\"index.php?c=AjaxDoc&m=GetPage&documentId=\"+docArr[j],function(result){\n" +
            "                $(\".TxtPic\").append(result);\n" +
            "                $(\".mod_page2\").hide();\n" +
            "            });\n" +
            "            var waitStatus = false;\n" +
            "            $(window).scroll(function () {\n" +
            "        \t    var topLoad = parseInt($(\"#loader\").offset().top);\n" +
            "                var Loading = $(window).scrollTop();\n" +
            "                if((topLoad-Loading)<=(2*h)){\n" +
            "                    if (false === waitStatus) {\n" +
            "                        waitStatus=true;\n" +
            "                        j++;\n" +
            "                        if(docArr[j] && typeof(docArr[j])!=\"undefined\" && docArr[j]!=0 ){\n" +
            "                            $(\".loading-div\").show();\n" +
            "                            $.get(\"index.php?c=AjaxDoc&m=GetPage&documentId=\"+docArr[j],function(result){\n" +
            "                                $(\".loading-div\").hide();\n" +
            "                                $(\".TxtPic\").append(result);\n" +
            "                                waitStatus = false;\n" +
            "                            });\n" +
            "                        }\n" +
            "                    }\n" +
            "                }\n" +
            "        \t});\n" +
            "        }\n" +
            "</script>\n" +
            "\n" +
            "\n" +
            "<!-- comments revision include -->\n" +
            "<script type=\"text/javascript\">\n" +
            "function vote(obj,comment_id,type,user,articleid,kindid){\n" +
            "\t$.getJSON('http://comments.cnmo.com/include/ajax/m_vote.php?callback=?', {comment_id:comment_id, type: type, articleid: articleid, user: user, kindid: kindid, rt: Math.random()}, function(data){\n" +
            "\t\tif(data == 1){\n" +
            "\t\t\tvar m = $(obj).html();\n" +
            "\t\t\tm = parseInt(m);\n" +
            "\t\t\tm = m + 1;\n" +
            "\t\t\t$(obj).html(m);\n" +
            "\t\t\t$(obj).removeAttr('onclick');\n" +
            "\t\t}\n" +
            "\t});\n" +
            "}\n" +
            "\n" +
            "function insertReplyComments(commentid, comments, nickname)\n" +
            "{\n" +
            "\tvar str = \"\";\n" +
            "\n" +
            "\tfor(var i = 0, len = comments.length; i < len; ++i)\n" +
            "\t{\n" +
            "\t\tvar comment = comments[i];\n" +
            "\t\t\n" +
            "\t\tstr = str + '<div class=\"comment_lou\"> \\\n" +
            "\t\t\t\t\t\t<div class=\"commnetoDiv\" style=\"display:block\">' + \n" +
            "\t\t\t\t\t\t\t'<header class=\"c1Tit\"><span class=\"r\">' + comment[\"nickname\"] + '@' + nickname + \n" +
            "\t\t\t\t\t\t\t'</span><span class=\"rightDate\">' + comment[\"posttime\"] + '</span></header> \\\n" +
            "\t\t\t\t\t\t\t<article class=\"commentTxt-p\">\\\n" +
            "\t\t\t\t\t\t\t<p>'+  comment[\"content\"] + '</p>\\\n" +
            "\t\t\t\t\t\t\t</article>\\\n" +
            "\t\t\t\t\t\t</div>\\\n" +
            "\t\t\t\t\t</div>';\n" +
            "\t}\n" +
            "\t\n" +
            "\t$(\"#replyComments_\" + commentid).html(str);\n" +
            "}\n" +
            "\n" +
            "var visited = {};\n" +
            "\n" +
            "//显示隐藏的层\n" +
            "function showReplay(obj, commentid, articleid, nickname){\n" +
            "\n" +
            "\tvar oReplay=obj.parentNode.nextElementSibling||obj.parentNode.nextSibling;\n" +
            "\tif(!oReplay.style){return;}\n" +
            "\tif(oReplay.style.display=='block'){\n" +
            "\t\toReplay.style.display='none';\n" +
            "\t}else{\n" +
            "\t\tif(undefined == visited[commentid])\n" +
            "\t\t{\n" +
            "\t\t\tvar url = \"index.php?c=CommentAjax&m=GetReplyComments\";\n" +
            "\t\t\tvar jsonAjax = {articleId: articleid, commentid: commentid};\n" +
            "\t\t\t$.post(url, jsonAjax, function (data)\n" +
            "\t\t\t{\n" +
            "\t\t\t\tvar comments = jQuery.parseJSON(data);\n" +
            "\t\t\t\tinsertReplyComments(commentid, comments, nickname);\n" +
            "\t\t\t\tvisited[commentid] = true;\n" +
            "\t\t\t});\n" +
            "\t\t}\n" +
            "\t\toReplay.style.display='block';\n" +
            "\t}\n" +
            "}\n" +
            "</script>\n" +
            "<script type=\"text/javascript\" src=\"http://static.cnmo-img.com.cn/touch/uncle_spit/js/index.js\"></script>\n" +
            "<!-- comments revision include -->\n" +
            "\n" +
            "<script type=\"text/javascript\" src=\"http://static.cnmo-img.com.cn/touch/js/touch-public.min.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"http://static.cnmo-img.com.cn/js/siteLogin.js?id=user_login&tmp=touchNormall\"></script></body></html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webView);
        WebSettings mWebSettings = webView.getSettings();
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setBuiltInZoomControls(true);
        mWebSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                System.out.println("shouldOverrideUrlLoading: " + url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                System.out.println("onPageStarted: " + url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("onPageFinished: " + url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                System.out.println("onLoadResource: " + url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                System.out.println("onReceivedError: [errorcode: " + errorCode + "] [description: " + "] [failingUrl: " + failingUrl + "]" );
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                System.out.println("onProgressChanged: " + newProgress);
            }



        });
//        webView.loadUrl(getString(R.string.test_data_url));
    webView.loadData(data, "text/html; charset=UTF-8", null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
