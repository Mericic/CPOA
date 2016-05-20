<?php
$title='Première Connexion';
$titlePage='Welcome Home';
ob_start();

echo '
<form method="post" action="index.php?Premiere">
	<label>Login :</label> <input type="text" name="Login" /></br>
	<label>Mooot de Passe :</label><input type="password" name="Pass"/></br>
	<label>Nom :</label> <input type="text" name="Nom" /></br>
	<label>Email :</label> <input type="text" name="Email" /></br>
	<input type="submit" value="valider"/>
</form>';

echo'
<br>
		<form method="post" action="index.php?Connexion">
			<label>Login :</label> <input type="text" name="Login" /></br>
			<label>Mooot de Passe :</label><input type="password" name="Pass"/></br>
			<input type="submit" value="valider"/>
		</form>
';

$content=ob_get_clean();

include_once('layout.php');
?> 