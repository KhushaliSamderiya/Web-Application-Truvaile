<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="Images/logo01.png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style03.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <title>The Survey | Truvaile</title>
</head>
<body>
   <%
      if (session.getAttribute("Username")==null)
      {
    	  response.sendRedirect("loginSurveyAcess.html");

      }
   %>
   
   <header class="main" style="background-image: linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url('Images/BgSurvey.jpg'); height: 80vh;">
        <div class="header-cotainer">
           <div class="top-container">
                <nav class="navigation container">
                    <div class="nav-brand">Truvaile</div>
                    <ul class="list-non-bullet nav-pills">
                        <li class="list-item-inline">
                            <a class="link " href="home.html">Home</a>
                        </li>
                        <li class="list-item-inline">
                            <a class="link " href="about.html">About us</a>
                        </li>
                        <li class="list-item-inline">
                            <a class="link" href="working.html">How it works</a>
                        </li>
                        <li class="list-item-inline">
                            <a class="link link-active" href="/">The Survey</a>
                        </li>
                        <li class="list-item-inline">
                            <a class="link" href="contact.html">Contact us</a>
                        </li>
                        <li class="list-item-inline">
                          <div class="dropdown" style="background-color: transparent;">
                            <button class="dropbtn"> 
                                <i class="far fa-user-circle"></i>
                            </button>
                            <div class="dropdown-content">
                              <a href="login.html">Login</a>
                              <a href="signup.html">Signup</a>
                              <a href="WelcomeAdmin.html">Admin</a><hr/>
                              <a href="Logout">Logout</a>
                            </div>
                          </div>
                        </li>
                    </ul>
                 </nav>
            </div>
                
            <div class="container-caption">
                <h2 class="header-caption">THE SURVEY</h2>
                <p class="header-para">Answer a few quick questions regarding date, budget & interests</p>
             </div>
         </div>
</header>
<section class="survey-container">
    <h2 class="heading">GET READY TO SURPRISE YOURSELF!</h2>
    <div class="form-control">
        <i class="small">Fields marked * are required</i><br><br>
        <form action="SurveyResponse" method="post">		
          <label class="question" for="Date Of Travel">Date Of Travel*:</label><br><br>
          <input type="date" id="Date Of Travel" name="Traveldate" placeholder="MM-DD-YYYY" required><br><br><br>

          <label class="question" for="duration">Duration Of Travel?*</label><br><br>
          <select id="duration" name="duration" required>
            <option value="please select....">please select.....</option>
            <option value="3N/4D">3N/4D</option>
            <option value="4N/5D">4N/5D</option>
            <option value="5N/6D">5N/6D</option>
            <option value="6N/7D">6N/7D</option>
            </select><br><br><br>

          
          <label class="question" for="Budget">Tentative Budget?*</label><br><br>
          <i class="small">The tentative budget will be updated as per your preferred mode of travel and accommodation.</i><br><br>
          <select id="Budget" name="budget" required>
            <option value="please select....">please select....</option>
            <option value="4000">Rs.4000 per person per night</option>
            <option value="5500">Rs.5500 per person per night</option>
            <option value="7000">Rs.7000 per person per night</option>
            <option value="9000">Rs.9000 per person per night</option></select><br><br><br>
            
            <label class="question" for="Travellers">Number Of Travelers?* </label><br><br>
          <select id="Travellers" name="NumberOfTravelers" required>
            <option value="please select....">please select.....</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6+">6+</option></select><br><br><br>
            
           <label class="question" for=" prefer">When you travel, You prefer: </label><br>
          <i class="small"> When does the Wanderlust inside you come to life?</i><br><br>
         
          <input type="radio"  name="preferance" value="Relaxation">
          <label for="1"> Relaxation</label><br>
          <input type="radio" name="preferance" value="Adventure">
          <label for="2"> Adventure</label><br>
          <input type="radio"  name="preferance" value="Mountains">
          <label for="1"> Mountains</label><br>
          <input type="radio"  name="preferance" value="Beach">
          <label for="1"> Beach</label><br>
          <input type="radio" name="preferance" value="Camping/Trekking">
          <label for="1"> Camping/Trekking</label><br>
          <input type="radio"  name="preferance" value="Historical/Heritage">
          <label for="1"> Historical/Heritage</label><br><br><br>
          
          <label class="question" for="Accommodation">Type of Accommodation?* </label><br><br>
          <select id="Accommodation" name="Accommodation" required>
            <option value="please select....">please select.....</option>
            <option value="Hostel">Hostel</option>
            <option value="Home Stay">Home Stay</option>
            <option value="Hotel">Hotel</option>
            <option value="Resort">Resort</option>
            <option value="Open to options that fit many budget">Open to options that fit many budget</option></select><br><br><br>
            
            <label class="question" for="Mode">Mode Of Travel: </label><br><br>
            <i class="small">How do you wish to be teleported to your surprise destination?</i><br><br>
          <select id="Mode" name="Mode" required>
            <option value="please select....">please select.....</option>
            <option value="Train">Train</option>
            <option value="Bus">Bus</option>
            <option value="Flight">Flight</option>
            <option value="Open to options that fit many budget">Open to options that fit many budget</option></select><br><br><br>
            
            <label class="question" for="city">Departure City*: </label><br><br>
            <i>From where would you be departing for the trip!</i><br><br>
          <input type="text" id="city" name="city" required><br><br><br>
        
         <label class="question" for="extra-info">What else do we need to know?</label><br>
        <i class="small">Do you have any physical limitations? Is this trip celebrating anything? Feel free to ask ANYTHING.</i><br><br>
        
          <textarea name="message" rows="4" cols="50" placeholder="Tell us more" required></textarea>
          <br><br>
        <input type="checkbox" id="01" name="1" value="I've read and accept the <b>Terms & Conditions</b>" required>
          <label for="1">I've read and accept the <b>Terms & Conditions</b></label><br><br><br>
          
          <input class="btn" type="submit">
        </form>
        
    </div>
</section>
<footer class="footer">
    
    <div class="footer-header">
        <div class="icon">
           <a href="#" class="link"><i class="fas fa-chevron-up"></i></a></div>
        <p>© 2020 Truvaile Trips Pvt Ltd.</p>
    </div>
    <ul class="social-link list-non-bullet">
        <li class="list-item-inline">
            <a href="#" class="link"><i class="fab fa-linkedin-in"></i></a> 
        </li>
        <li class="list-item-inline">
            <a href="#" class="link"><i class="fab fa-facebook-f"></i></a> 
        </li>
        <li class="list-item-inline">
            <a href="#" class="link"><i class="fas fa-play"></i></a> 
        </li>
        <li class="list-item-inline">
            <a href="#" class="link"><i class="fab fa-instagram"></i></a> 
        </li>
        <li class="list-item-inline">
            <a href="#" class="link"><i class="fab fa-twitter"></i></a> 
        </li>
    </ul>


</footer>
</body>
</html>