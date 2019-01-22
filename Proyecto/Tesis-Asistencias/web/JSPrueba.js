/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function fnc() {
document.getElementById('table-scroll').onscroll = function() {

document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
document.getElementById('fixedX').style.left = document.getElementById('table-scroll').scrollLeft + 'px';

};
}

window.onload = fnc;
