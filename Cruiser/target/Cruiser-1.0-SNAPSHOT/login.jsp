<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tades - Login</title>

        <!-- Icon Logo-->
        <!--  <link rel="icon" href="caminho">-->

        <!-- Bootstrap -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">-->
        <!-- Font Awesome-->
        <link rel="stylesheet" href="libs/fontawesome-free-5.13.0-web/css/all.min.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/login.css">

    </head>

    <body>

        <section>

            <div class="container">

                <div class="row">
                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">

                        <div class="card card-signin my-5">

                            <div>
                                <img class="logo-img" src="imagens/exemplo.png" alt="">
                            </div>


                            <div class="card-body">

                                <form class="form-signin">

                                    <div class="form-label-group">

                                        <label for="inputEmail">Email</label>
                                        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" required autofocus>

                                    </div>

                                    <div class="form-label-group">

                                        <label for="inputPassword">Senha</label>
                                        <input type="password" id="inputPassword" name="inputPassword" class="form-control input_pass" placeholder="Senha" required>

                                    </div>
                                    <hr>

                                    <button class="btn btn-lg btn-outline-light btn-block text-uppercase" type="submit">Acessar</button>
                                    <hr>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <footer class="text-center">
            <div class="container">
                <p class="text-white">DIREITOS RESERVADOS CRUISER 2020</p>
            </div>
        </footer>

    </body>

    <script src="libs/jquery/jquery.min.js"></script>
    <!--  <script src="libs/bootstrap/js/bootstrap.bundle.min.js"></script>-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>

</html>