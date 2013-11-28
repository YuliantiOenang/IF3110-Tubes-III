<?php
class View
{
    private $data = array();
    private $render = FALSE; //berisi lokasi file, bernilai false apabila belum diassign
    public function __construct($template)
    {
        $file = SERVER_ROOT.'/lihat/'.strtolower($template).'.php'; //lokasi view
        if (file_exists($file)) $this->render = $file;
		  else die('file view tidak ditemukan');
    }
    
    public function setData($variable , $value)
    {
		  //Ngeset data yang akan dikirim kepada view
        $this->data[$variable] = $value;
    }

    public function render($direct_output = TRUE)
    {
        /* Param direct_output digunakan apakah ada view lain
		  	  yang diembed kedalam view ini
		  */
        if ($direct_output !== TRUE) ob_start(); //output buffer start
        $data = $this->data;
        include($this->render); //include view
        
        if ($direct_output !== TRUE) return ob_get_clean(); //output buffer clean
        
    }
}
