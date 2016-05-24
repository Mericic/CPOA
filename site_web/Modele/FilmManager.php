<?php
class FilmManager extends Model
{

	public function getInfoFilmByGenre($Genre)
	{
		$req=$this->executerRequete('SELECT * FROM Film WHERE LibelleGenre = ?', array($Genre));
		return $req->fetchAll();
	}
	
	public function getGenre()
	{
		$req=$this->executerRequete('SELECT * FROM Genre');
		return $req->fetchAll();
	}
	
	public function getAllFilms()
	{
		$req=$this->executerRequete('SELECT * from 	Film');
		return $req->fetchAll();
	}

}


?>
