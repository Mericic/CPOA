<?php
class VIPManager extends Model
{
	public function getInfoVIP($NomVIP)//Permet de prendre sur la base toutes les infos sur un VIP
	{
		$req=$this->executerRequete('SELECT * from VIP WHERE nomVIP= ? ', array($NomVIP));
		return $req->fetch();
	}
	
	public function getnumVIP($nomVIP)
	{
		$req=$this->executerRequete('SELECT numVIP from VIP WHERE nomVIP= ? ',array($nomVIP));
		$data=$req->fetch();
		return $data;
	}
	
	public function getInfoVIPbynum($numVIP)
	{
		$req=$this->executerRequete('SELECT * from VIP WHERE numVIP= ? ', array($numVIP));
		return $req->fetch();
	}
	
	public function getAllVIP()
	{
		$req=$this->executerRequete('SELECT * FROM VIP');
		return $req->fetchAll();
	}
	
	public function getNomVIP($numVIP)
	{
		$req=$this -> executerRequete('SELECT nomVIP, prenomVIP from VIP WHERE numVIP = ?', array($numVIP));
		$data=$req->fetchAll();
		return $data;
	}

	public function getMariage($numVIP)
	{
		$req=$this->executerRequete('SELECT * from Evenement WHERE numVIP= ?',array($numVIP));
		$data=$req->fetchAll();
		return $data;
	}
}
?>