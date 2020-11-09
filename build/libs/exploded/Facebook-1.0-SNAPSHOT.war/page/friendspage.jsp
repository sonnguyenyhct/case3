<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>Hihi-haha</title>
    <link rel="icon" href="page/images/mini.png" type="image/png" sizes="16x16">

    <link rel="stylesheet" href="page/css/main.min.css">
    <link rel="stylesheet" href="page/css/style.css">
    <link rel="stylesheet" href="page/css/color.css">
    <link rel="stylesheet" href="page/css/responsive.css">

</head>
<body>
<!--<div class="se-pre-con"></div>-->
<div class="theme-layout">
    <div class="topbar stick">
        <div class="logo">
            <a title="" href="/home" ><img src="page/images/logo.png" alt="" style="width: 125px; height: 45px"></a>
        </div>

        <div class="top-area">
            <ul class="main-menu">
                <li>
                    <a href="#" title="">Home</a>
                    <ul>
                        <li><a href="" title="">My page</a></li>
                        <li><a href="" title="">news feed</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" title="">account settings</a>
                    <ul>
                        <li><a href="edit-account-setting.html" title="">edit account setting</a></li>
                        <li><a href="edit-password.html" title="">edit-password</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="setting-area">
                <li>
                    <a href="#" title="Home" data-ripple=""><i class="ti-search"></i></a>
                    <div class="searched">
                        <form method="post" class="form-search">
                            <input type="text" placeholder="Search Friend">
                            <button data-ripple><i class="ti-search"></i></button>
                        </form>
                    </div>
                </li>
                <li><a href="newsfeed.html" title="Home" data-ripple=""><i class="ti-home"></i></a></li>
                <li>
                    <a href="#" title="Notification" data-ripple="">
                        <i class="ti-bell"></i><span>ThÃ´ng bÃ¡o</span>
                    </a>
                    <div class="dropdowns">
                        <span>***** New Notifications</span>
                        <ul class="drops-menu">
                            <li>
                                <a href="notifications.html" title="">
                                    <img src="page/images/resources/thumb-1.jpg" alt="">
                                    <div class="mesg-meta">
                                        <h6>sarah Loren</h6>
                                        <span>Hi, how r u dear ...?</span>
                                        <i>2 min ago</i>
                                    </div>
                                </a>
                                <span class="tag green">New</span>
                            </li>
                        </ul>
                        <a href="notifications.html" title="" class="more-mesg">view more</a>
                    </div>
                </li>
            </ul>
            <div class="user-img">
                <img src="page/images/resources/admin.jpg" alt="">
                <span class="status f-online"></span>
                <div class="user-setting">
                    <a href="/login" title=""><i class="ti-user"></i> view profile</a>
                    <a href="#" title=""><i class="ti-pencil-alt"></i>edit profile</a>
                    <a href="#" title=""><i class="ti-settings"></i>account setting</a>
                    <a href="#" title=""><i class="ti-power-off"></i>log out</a>
                </div>
            </div>
        </div>
    </div><!-- topbar -->
    <section>
        <div class="feature-photo">
            <figure><img src="${user.getAvatarCover()}" alt=""></figure>
            <form class="edit-phto">
                <i class="fa fa-camera-retro"></i>
                <label class="fileContainer">
                    Edit Cover Photo
                    <input type="file"/>
                </label>
            </form>
            <div class="container-fluid">
                <div class="row merged">
                    <div class="col-lg-2 col-sm-3">
                        <div class="user-avatar">
                            <figure>
                                <img src="${user.getAvatar()}" alt="">
                                <form class="edit-phto">
                                    <i class="fa fa-camera-retro"></i>
                                    <label class="fileContainer">
                                        Edit Display Photo
                                        <input type="file"/>
                                    </label>
                                </form>
                            </figure>
                        </div>
                    </div>
                    <div class="col-lg-10 col-sm-9">
                        <div class="timeline-info">
                            <ul>
                                <li class="admin-name">
                                    <h5>${user.getName()}</h5>
                                </li>
                                <li>
                                    <a class="" href="/personalpage" title="" data-ripple="">time line</a>
                                    <a class="" href="timeline-photos.html" title="" data-ripple="">Photos</a>
                                    <a class="" href="timeline-videos.html" title="" data-ripple="">Videos</a>
                                    <a class="" href="/friendspage" title="" data-ripple="">Friends</a>
                                    <a class="" href="timeline-groups.html" title="" data-ripple="">Groups</a>
                                    <a class="" href="about.html" title="" data-ripple="">about</a>
                                    <a class="" href="#" title="" data-ripple="">more</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section><!-- top area -->
    <section>
        <div class="gap gray-bg">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row" id="page-contents">
                            <div class="col-lg-3">
                                <aside class="sidebar static">
                                    <div class="widget">
                                        <h4 class="widget-title">Shortcuts</h4>
                                        <ul class="naves">
                                            <li>
                                                <i class="ti-clipboard"></i>
                                                <a href="newsfeed.html" title="">News feed</a>
                                            </li>
                                            <li>
                                                <i class="ti-files"></i>
                                                <a href="fav-page.html" title="">My pages</a>
                                            </li>
                                            <li>
                                                <i class="ti-user"></i>
                                                <a href="timeline-friends.html" title="">friends</a>
                                            </li>
                                            <li>
                                                <i class="ti-image"></i>
                                                <a href="timeline-photos.html" title="">post</a>
                                            </li>
                                            <i class="ti-power-off"></i>
                                            <a href="landing.html" title="">Logout</a>
                                            </li>
                                        </ul>
                                    </div><!-- Shortcuts -->
                                    <div class="widget stick-widget">
                                        <h4 class="widget-title">Suggestion to make friends</h4>
                                        <ul class="followers">
                                            <li>
                                                <figure><img src="page/images/resources/friend-avatar2.jpg" alt=""></figure>
                                                <div class="friend-meta">
                                                    <h4><a href="time-line.html" title="">Kelly Bill</a></h4>
                                                    <a href="#" title="" class="underline">Add Friend</a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div><!-- who's following -->
                                </aside>
                            </div><!-- sidebar -->
                            <div class="col-lg-6">
                                <div class="central-meta">
                                    <div class="frnds">
                                        <ul class="nav nav-tabs">
                                            <li class="nav-item"><a class="active" href="#frends" data-toggle="tab">My Friends</a> <span>55</span></li>
                                            <li class="nav-item"><a class="" href="#frends-req" data-toggle="tab">Friend Requests</a><span>60</span></li>
                                        </ul>

                                        <!-- Tab panes -->
                                        <div class="tab-content">
                                            <div class="tab-pane active fade show " id="frends" >
                                                <ul class="nearby-contct">
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/friend-avatar9.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">jhon kates</a></h4>
                                                                <span>ftv model</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly1.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">sophia Gate</a></h4>
                                                                <span>tv actresses</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly2.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">sara grey</a></h4>
                                                                <span>work at IBM</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly3.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">Sexy cat</a></h4>
                                                                <span>Student</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly4.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">Sara grey</a></h4>
                                                                <span>ftv model</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly5.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">Amy watson</a></h4>
                                                                <span>Study in university</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly6.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">caty lasbo</a></h4>
                                                                <span>work as dancers</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly2.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">Ema watson</a></h4>
                                                                <span>personal business</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">unfriend</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">add friend</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <div class="lodmore"><button class="btn-view btn-load-more"></button></div>
                                            </div>
                                            <div class="tab-pane fade" id="frends-req" >
                                                <ul class="nearby-contct">
                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly5.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">Amy watson</a></h4>
                                                                <span>ftv model</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">delete Request</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">Confirm</a>
                                                            </div>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <div class="nearly-pepls">
                                                            <figure>
                                                                <a href="time-line.html" title=""><img src="page/images/resources/nearly1.jpg" alt=""></a>
                                                            </figure>
                                                            <div class="pepl-info">
                                                                <h4><a href="time-line.html" title="">sophia Gate</a></h4>
                                                                <span>ftv model</span>
                                                                <a href="#" title="" class="add-butn more-action" data-ripple="">delete Request</a>
                                                                <a href="#" title="" class="add-butn" data-ripple="">Confirm</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <button class="btn-view btn-load-more"></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- centerl meta -->
                            <div class="col-lg-3">
                                <aside class="sidebar static">
                                    <div class="widget friend-list stick-widget">
                                        <h4 class="widget-title">Friends</h4>
                                        <div id="searchDir"></div>
                                        <ul id="people-list" class="friendz-list">
                                            <li>
                                                <figure>
                                                    <img src="page/images/resources/friend-avatar.jpg" alt="">
                                                    <span class="status f-online"></span>
                                                </figure>
                                                <div class="friendz-meta">
                                                    <a href="time-line.html">bucky barnes</a>
                                                    <i><a href="https://wpkixx.com/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="a0d7c9ced4c5d2d3cfccc4c5d2e0c7cdc1c9cc8ec3cfcd">[email&#160;protected]</a></i>
                                                </div>
                                            </li>
                                        </ul>
                                    </div><!-- friends list sidebar -->
                                </aside>
                            </div><!-- sidebar -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="widget">
                        <div class="foot-logo">
                            <div class="logo">
                                <a href="/home" name="friendBack" title="" ><img src="images/logo.png" alt=""></a>
                            </div>
                            <p>
                                HÃ  Ná»™i
                            </p>
                        </div>
                        <ul class="location">
                            <li>
                                <i class="ti-map-alt"></i>
                                <p>HÃ  Ná»™i</p>
                            </li>
                            <li>
                                <i class="ti-mobile"></i>
                                <p>+0988.888.888</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-md-4">
                    <div class="widget">
                        <div class="widget-title"><h4>follow</h4></div>
                        <ul class="list-style">
                            <li><i class="fa fa-facebook-square"></i> <a href="https://web.facebook.com/shopcircut/" title="">facebook</a></li>
                            <li><i class="fa fa-twitter-square"></i><a href="https://twitter.com/login?lang=en" title="">twitter</a></li>
                            <li><i class="fa fa-instagram"></i><a href="https://www.instagram.com/?hl=en" title="">instagram</a></li>
                            <li><i class="fa fa-google-plus-square"></i> <a href="https://plus.google.com/discover" title="">Google+</a></li>
                            <li><i class="fa fa-pinterest-square"></i> <a href="https://www.pinterest.com/" title="">Pintrest</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-8">
                    <div class="widget">
                        <div class="widget-title"><h4>Map</h4></div>
                        <iframe src="https://www.google.com/maps/embed?pb=!4v1604559304230!6m8!1m7!1sJp8VcoXA01nEAdcFrdqpcg!2m2!1d13.72842531526915!2d100.5320375830265!3f292.49937924606724!4f9.02792330310028!5f0.7820865974627469" style="width: 100%" height="300" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                    </div>
                </div>
                <div class="col-lg-2 col-md-4">
                    <div class="widget">
                        <div class="widget-title"><h4>download apps</h4></div>
                        <ul class="colla-apps">
                            <li><a href="https://play.google.com/store?hl=en" title=""><i class="fa fa-android"></i>android</a></li>
                            <li><a href="https://www.apple.com/lae/ios/app-store/" title=""><i class="ti-apple"></i>iPhone</a></li>
                            <li><a href="https://www.microsoft.com/store/apps" title=""><i class="fa fa-windows"></i>Windows</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer><!-- footer -->
</div>
<div class="side-panel">
    <h4 class="panel-title">General Setting</h4>
    <form method="post">
        <div class="setting-row">
            <span>use night mode</span>
            <input type="checkbox" id="nightmode1"/>
            <label for="nightmode1" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Notifications</span>
            <input type="checkbox" id="switch22" />
            <label for="switch22" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Notification sound</span>
            <input type="checkbox" id="switch33" />
            <label for="switch33" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>My profile</span>
            <input type="checkbox" id="switch44" />
            <label for="switch44" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Show profile</span>
            <input type="checkbox" id="switch55" />
            <label for="switch55" data-on-label="ON" data-off-label="OFF"></label>
        </div>
    </form>
    <h4 class="panel-title">Account Setting</h4>
    <form method="post">
        <div class="setting-row">
            <span>Sub users</span>
            <input type="checkbox" id="switch66" />
            <label for="switch66" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>personal account</span>
            <input type="checkbox" id="switch77" />
            <label for="switch77" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Business account</span>
            <input type="checkbox" id="switch88" />
            <label for="switch88" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Show me online</span>
            <input type="checkbox" id="switch99" />
            <label for="switch99" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Delete history</span>
            <input type="checkbox" id="switch101" />
            <label for="switch101" data-on-label="ON" data-off-label="OFF"></label>
        </div>
        <div class="setting-row">
            <span>Expose author name</span>
            <input type="checkbox" id="switch111" />
            <label for="switch111" data-on-label="ON" data-off-label="OFF"></label>
        </div>
    </form>
</div><!-- side panel -->

<script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="page/js/main.min.js"></script>
<script src="page/js/script.js"></script>
<script src="page/js/map-init.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8c55_YHLvDHGACkQscgbGLtLRdxBDCfI"></script>

</body>

</html>