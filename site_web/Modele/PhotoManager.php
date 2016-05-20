<?php
class PhotoManager extends Model{
		public function getPhoto($numVIP)
		{			

				
				$req=$this->executerRequete('SELECT * from PhotoVIP WHERE numVIP = ?',array($numVIP));
				$data=$req->fetchAll();
				return $data;
		}
		
}
?>