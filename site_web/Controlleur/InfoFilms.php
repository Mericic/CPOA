




<?php
	
	if(isset($_POST['Titre']) && isset($_POST['Realisateur']) && isset($_POST['annee']) && isset($_POST['numVisa']) && isset($_POST['VIP']))
	{
		$InfoFilm= new FilmManager();
		if($_POST['Titre']!=Null)
		{
			echo 'Seulement la description de'.$_POST['Titre'].'</br>'.
			$unFilm = $InfoFilm -> getInfoFilmByTitle($_POST['Titre']);
		}else
		{
			echo 'tous les films';
			$tousLesFilms = $InfoFilm -> getAllFilms();
		}
	}
	
	
	
?>