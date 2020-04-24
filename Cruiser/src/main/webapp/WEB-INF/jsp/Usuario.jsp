<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <form method="POST" action="Usuario">
            <input type="hidden" name="sessao" value="CREATE"/>
            <h1 class="text-center"> CADASTRAR USUÁRIO</h1>

            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Nome</label>
                    <input type="text" class="form-control" name="nomeUsuario" value="${usuario.nomeUsuario}">
                </div>
                <div class="form-group col-md-4">
                    <label >Senha</label>
                    <input type="password" class="form-control" name="senhaUsuario" value="${usuario.senhaUsuario}">
                </div>


                <div class="form-group col-md-4">
                    <label for="inputState">Permissao de acesso</label>
                    <select id="inputState" class="form-control" name="permissaoUsuario"  value="${usuario.permissaoUsuario}" >
                        <option selected>SELECIONE</option>
                        <option>DIRETORIA</option>
                        <option>GERENTE</option>
                        <option>PEAO</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">SALVAR</button>

        </form>
    </body>
</html>
