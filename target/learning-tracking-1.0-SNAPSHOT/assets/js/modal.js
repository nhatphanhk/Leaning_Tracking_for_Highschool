/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function() {
    // Listen for click events on the update buttons
    $('.btn-update').on('click', function() {
        // Get the notification data from the button's data-* attributes
        var title = $(this).data('title');
        var content = $(this).data('content');
        var notificationid = $(this).data('notificationid');

        // Set the notification data in the modal fields
        $('#ChangeNotiModal input[name="title"]').val(title);
        $('#ChangeNotiModal textarea[name="content"]').val(content);
        $('#ChangeNotiModal input[name="notificationid"]').val(notificationid);

        // Show the modal
        $('#ChangeNotiModal').modal('show');
    });
});
