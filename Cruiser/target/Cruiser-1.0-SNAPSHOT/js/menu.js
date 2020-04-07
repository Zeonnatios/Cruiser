let iconMenu = document.getElementById('iconMenu');
let sidebar = document.getElementById('sidebar');
let mainContent = document.getElementById('mainContent');
//let droplist = document.getElementById('drop-list');

function responsiveSidebar() {

    if (sidebar.style.display == 'none') {

        sidebar.style.display = 'block';
        mainContent.style.width = 'calc(100% - 300px);';
    } else {
        sidebar.style.display = 'none';
        mainContent.style.width = '100%';
    }

}


/* Lista ul li ao clicar*/

$(document).ready(function(e) {
    $('.drop-list').click(function() {
        $(this).toggleClass('tap');
    });
});