<?php
	function isSelected($nb){
		if(isset($_POST['genre']) && $_POST['genre']==$nb)
		{
			return 'selected';
		}else if(!isset($_POST['genre']) && $nb==4){
			return 'selected';
		}
	}
?>