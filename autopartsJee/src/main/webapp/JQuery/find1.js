$(document).ready(function () {
    $("li a").click(function () {

        var temp = $(this).text();

        $.get('find-questions',{name:'name'}, function () {
            alert(temp);
            temp;
        })


        // $("li a").hide();
        // $(this).show();
        //
        // var temp = $(this).text();
        //
        // alert(temp);
        //
        // $.get('find-questions', function (temp) {
        //     alert(temp);
        // });

    });
});



// $(document).ready(function () {
//     $("li a").click(function () {
//
//         $("li a").hide();
//         $(this).show();
//
//         var temp = $(this).text();
//
//         alert(temp);
//
//         $.get('find-questions', function (temp) {
//             alert(temp);
//         });
//
//     });
// });

// $(this).hide();
// $(this).css('background', 'inherit');
// $(this).css("background-color", "violet");

// $('#output').text($(this).val());
// var temp = $("#abc").val();
// $(this).attr()
// alert($(this).text());

// $(document).ready(function(){
//     $("select").change(function(){
//         $("input[type=text]").val($(this).val());
//     });
// });