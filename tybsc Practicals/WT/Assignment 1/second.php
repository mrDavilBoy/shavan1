<?php
  
  echo "Style is : ".$_POST['s1']."<br>"; 
  echo "Size is : ".$_POST['s']."<br>";
  echo "Color is : ".$_POST['c']."<br>";
  echo "Background color is : ".$_POST['b']."<br>";
  setcookie("set1",$_POST["s1"]);
  setcookie("set2",$_POST["s"]);
  setcookie("set3",$_POST["c"]);
  setcookie("set4",$_POST["b"]);
  
?>

<html>
   <body>
       <form action="third.php">
       <input type="submit" name="submit" value="OK">
       </form>
   </body>
</html>
