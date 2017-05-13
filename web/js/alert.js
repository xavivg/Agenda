/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
  $('.btn-success').click(function() {
    $('.notification').slideDown('fast');
    window.setTimeout(close3,5000);
  });
});
function close3() {
  $('.notification').fadeOut('slow');
}

