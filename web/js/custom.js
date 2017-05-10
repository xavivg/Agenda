/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('#login').click(function () {
        $('#autorized').animate({'top': '0px'}, 200);
        return false;
    });
    $('#closeau').click(function () {
        $('#autorized').animate({'top': '-999px'}, 500);
    });
    $('#addContact').click(function (){
        $('#pl').animate({'top':'0'}, 200);
        return false;
    });
    $('#close').click(function (){
        $('#pl').animate({'top':'-150%'}, 500);
        return false;
    });
});
function changeClass(){
    $("#pushy-left").toggleClass("pushy-open");
};
