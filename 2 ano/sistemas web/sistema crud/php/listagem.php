<?php
    include_once('conexao.php'); // inclui conexão
    $query = mysqli_query($connect, "SELECT * FROM `aluno`"); // armazena o comando sql
    $linha = mysqli_fetch_assoc($query); // transforma o resultado em uma array
    $total = mysqli_num_rows($query); // conta as linhas de dados

?>
<html>
	<head>
	    <title>Listagem</title>
    </head>
    <body>
        <form method="POST" action="modificar.php">
            <table border="1">
                <tr>
                    <th>Matrícula</th>
                    <th>Nome</th>
                    <th>Média</th>
                    <th></th>
                </tr>
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
                                <td><input type="radio" name="matricula" id="<?=$linha['matricula']?>_delete" value="<?=$linha['matricula']?>"></td>
                            </tr>
                <?php
                        // finaliza o loop que vai mostrar os dados
                        }while($linha = mysqli_fetch_assoc($query));
                    // fim do if
                    }
                ?>
            </table>
            <input type="submit" name="oper" value="Atualizar">
            <input type="submit" name="oper" value="Deletar">
        </form>
        <button onclick="window.location.href='../index.html'">Voltar</button>
    </body>
</html>
<?php
    // tira o resultado da busca da memória
    mysqli_free_result($query);
?>