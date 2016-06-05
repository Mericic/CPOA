<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title><?php echo $title ?></title>
		<link rel="stylesheet" href="assets/CSS/style.css" />
    </head>
	
    <body>
	<header>
	<h1><?php echo $titlePage; ?></h1>
	<div id="Menu">
			<a href="index.php?page=accueil" class="Choix">Accueil</a>

			<a href="index.php?page=ListeFilms	" class="Choix">Films</a>

			<a href="index.php?page=ficheVIP" class="Choix">Fiches VIP</a>

			<!--<a href="index.php" class="Choix">...</a>-->
	</div>
			<?php //echo $utilisateur;?>
	</header>
	<?php
	echo $content;
	?>
	
	<p class="bas"> Site cree en php html 5 et css</p>
	
    </body>
</html>