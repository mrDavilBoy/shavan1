<html>
   <head>
       <title>Change Preferences></title>
   </head>
   <body>
       <h1>Change Preferences</h1>
       <form action= "second.php" method="POST">
       <label for="s1">Font Style:</label>
       <select id="font_style" name="s1">
          <option value="Normal">Normal</option>
          <option value="Italic">Italic</option>
          <option value="oblique">oblique</option>
       </select><br><br>
       
       <label for="font_size">Font Size:</label>
       <select id="s" name="s">
          <option value="14px">Small</option>
          <option value="20px">Middle</option>
          <option value="28px">Large</option>
       </select><br><br>
       
       <label for="font_color">Font Color:</label>
       <select id="c" name="c">
          <option value="black">Black</option>
          <option value="green">Green</option>
          <option value="red">Red</option>
          <option value="blue">Blue</option>
       </select><br><br>
       
       <label for="bg_color">Background Color:</label>
       <select id="b" name="b">
          <option value="black">Black</option>
          <option value="green">Green</option>
          <option value="red">Red</option>
          <option value="blue">Blue</option>
       </select><br><br>
       
       <input type="submit" name="submit" value="Save Preferences">
       
     </form>
</html>
       
