// preloader
$(window).load(function () {
    $('.preloader').fadeOut(1000); // set duration in brackets    
});

function communityA(){
    if (memberId === '0') {
        alert("로그인 후 이용 가능합니다.");
    } else {
        window.location = "/community"
    }
}
$(function () {
    new WOW().init();
    $('.templatemo-nav').singlePageNav({
        offset: 70
    });

    /* Hide mobile menu after clicking on a link
    -----------------------------------------------*/
    $('.navbar-collapse a').click(function () {
        $(".navbar-collapse").collapse('hide');
    });

})