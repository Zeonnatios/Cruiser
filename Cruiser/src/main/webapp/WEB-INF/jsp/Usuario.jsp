<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - USUARIO</title>

        <!-- Icon Logo-->
        <style>
            body {
                background-image: url(imagens/FUNDO_CRUISER.png);
            }
        </style>


        <!-- Bootstrap -->
        <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome-->
        <link rel="stylesheet" href="libs/fontawesome-free-5.13.0-web/css/all.min.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/all.css">

    </head>

    <body>
        <form action="" method="POST">
            <!-- ID CLIENTE  -->
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">ID USUARIO: </label>
                <div class="col-lg-10">
                    <input type="number" class="form-control" id="inputIDCli" placeholder="ID AUTOMÁTICO" disabled>
                </div>
            </div>

            <!-- NOME DO FUNCIONARIO -->
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">NOME: </label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="inputNomeCli" placeholder="Nome" autofocus>
                </div>
            </div>

            <!-- SENHA PARA O FUNCIONARIO -->
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">SENHA DO FUNICIONARIO: </label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="inputCPFCli" placeholder="SENHA">
                </div>
            </div>



            <!-- Botao limpar-->
            <div class="campoBotoes">
                <button class="botao" type="button">Limpar</button>

                <!-- Botao Salvar-->
                <button class="botao" type="button">Salvar</button>
            </div>

        </form>
    </body>
</html>
