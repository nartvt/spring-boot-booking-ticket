$(document).ready(function () {
   $('#btnLogin').click(function (e) { 
       e.preventDefault();
       let  email = $('#lgEmail').val();
       let password = $('#lgPassword').val();

       let data ={
           email: email,
           password: password
       }

       $.ajax({
           url: "http://localhost:8080/login",
           type: "POST",
           contentType: "application/json; charset=utf-8",
        //    dataType: "json",
           data: JSON.stringify(data),
        //    success: function (response) {
        //        console.log(response);
        //    },
        //    error: function (error) {
        //     console.log(error);
        // }
       }).done(function (response) { 
           localStorage.setItem("TOKEN",response);
           console.log(response);
        }).fail(function(err){
            console.log(err);
        });
   });
});