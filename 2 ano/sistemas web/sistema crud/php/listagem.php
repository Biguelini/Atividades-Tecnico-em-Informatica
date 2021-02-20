<?php
    include_once('conexao.php'); // inclui conexão
    $query = mysqli_query($connect, "SELECT * FROM `aluno`"); // armazena o comando sql
    $linha = mysqli_fetch_assoc($query); // transforma o resultado em uma array
    $total = mysqli_num_rows($query); // conta as linhas de dados

?>
<html>
	<head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
	    <title>Listagem</title>
    </head>
    <body>
        <div class="container col-lg-4 col-md-6 col-sm-8 my-5">
            <h1 class="text-center">Alunos cadastrados</h1>
            <form method="POST" action="modificar.php">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Matrícula</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Média</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        // se o número de resultados for maior que zero, mostra os dados
                            if($total > 0) {
                                // inicia o loop que vai mostrar todos os dados
                                do {
                        ?>          
                                    <tr>
                                        <td><?=$linha['matricula']?></td>
                                        <td><?=$linha['nome']?></td>
                                        <td><?=$linha['media']?></td>
                                        <td><input type="radio" name="matricula" id="<?=$linha['matricula']?>_delete" value="<?=$linha['matricula']?>" checked></td>
                                    </tr>
                        <?php
                                // finaliza o loop que vai mostrar os dados
                                }while($linha = mysqli_fetch_assoc($query));
                            // fim do if
                            }
                        ?>
                    </tbody>
                </table>
                <div class="d-flex justify-content-center">
                    
                    <input type="submit" name="oper" value="Atualizar" class="btn btn-success me-3">
                    <input type="submit" name="oper" value="Deletar" class="btn btn-danger me-3">
                    <input type="submit" name="oper" value="Voltar" class="btn btn-primary">
                </div>
            </form>
        </div>
    </body>
</html>