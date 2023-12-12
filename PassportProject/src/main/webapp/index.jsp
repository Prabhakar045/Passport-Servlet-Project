<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration - Passport Page</title>

    <script>
        function validate() {

            var givenNamee = document.getElementById("givenName");
            var givenNameError = document.getElementById("givenNameError");
            givenNameError.innerHTML="";

            if (givenNamee.value.length < 3) {
                givenNameError.innerHTML = "given name must have at least 3 characters.";
                return false;
            }
            if (/\d/.test(givenNamee.value)) {
                // alert("Given Name should not contain numbers.");
                givenNameError.innerHTML="given name should not contain  numbers";

                return false;
            }


            var surrNamee = document.getElementById("surname");
            var surnameError = document.getElementById("surnameError");
            surnameError.innerHTML="";

            if (surrNamee.value.length > 5) {
                // alert("surname must have at most 5 characters ");
                surnameError.innerHTML="surname must have at most 5 characters";
                return false;
            }


            var password = document.getElementById("password");
            var passwordError = document.getElementById("passwordError");
            passwordError.innerHTML = "";

            if (password.value.length < 5) {
                passwordError.innerHTML = "Password must have at least 5 characters.";
                return false;
            }
            if (!/\d/.test(password.value)) {
                passwordError.innerHTML = "Password must contain at least one number.";
                return false;
            }



            var confirmPassword = document.getElementById("confirmPassword");
            var confirmPasswordError = document.getElementById("confirmPasswordError");
            confirmPasswordError.innerHTML = "";
            if (confirmPassword.value !== password.value) {
                confirmPasswordError.innerHTML = "password do not matched .";
                return false;
            }
        }


        function toggleLoginId() {
            var loginIdField = document.getElementById("loginId");
            var emailField = document.getElementById("email");
            var sameAsEmailCheckbox = document.getElementById("sameAsEmail");

            if (sameAsEmailCheckbox.checked) {
                loginIdField.value = emailField.value;
                loginIdField.setAttribute("readonly", true);
            } else {
                loginIdField.value = "";
                loginIdField.removeAttribute("readonly");
            }

            // Call the validate() method after updating the Login Id field
            validate();
        }
    </script>



    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            box-sizing: border-box;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input, select, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Add CSS for the header */
        header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: lightgreen;
            color: white;
            padding: 5px;
            text-align: center;
        }

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        nav ul li {
            display: inline;
            margin-right: 10px;
            text-decoration: none;
        }

        /* .radio-group {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 5px;
        }

        .radio-group label {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .radio-group input {
            margin-right: 5px;
            margin-bottom: 0;
        }
        */



        button {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<header>

    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#register">Register</a></li>
        </ul>
    </nav>
</header>


<form onchange="return validate()" action="passport" method="post">
    <h2>User Registration </h2>


    <label for="passportOffice">Passport Office:</label>
    <select id="passportOffice" name="passportOffice">
        <option value="bangalore">Bangaluru</option>
        <option value="pune">Pune</option>
        <option value="delhi">Delhi</option>
        <option value="mumbai">Mumbai</option>
        <option value="hyderbad">Hyderbad</option>

    </select>

    <label for="givenName">Given Name:</label>
    <input type="text" id="givenName" name="givenName" maxlength="45" required>
    <span id="givenNameError" class="error-message"></span>



    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" maxlength="45" required>
    <span id="surnameError"  ></span>


    <label for="birthday">Date of Birth:</label>
    <!--    <input type="text" id="dob" name="dob" placeholder="DD/MM/YYYY" required>-->
    <!--    <input type="datetime-local" id="Test_DatetimeLocal">-->
    <input type="date" id="birthday" name="birthday">




    <label for="email">E-mail Id:</label>
    <input type="email" id="email" name="email" maxlength="35" required>


    <!-- <div class="radio-group">
        <label for="sameAsEmailYes">
            <input type="radio" id="sameAsEmailYes" name="sameAsEmail" onclick="toggleLoginId()"> Yes
        </label>

        <label for="sameAsEmailNo">
            <input type="radio" id="sameAsEmailNo" name="sameAsEmail" onclick="toggleLoginId()"> No
        </label>
    </div> -->

    <label for="loginId">Login Id:</label>
    <input type="text" id="loginId" name="loginId" required>



    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <span id="passwordError" class="error-message"></span>
    <span id="confirmPasswordError" class="error-message"></span>


    <label for="confirmPassword">Confirm Password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required>

    <label for="hintQuestion">Hint Question:</label>
    <select id="hintQuestion" name="hintQuestion">
        <option value="Favorite cricketert">Favorite cricketer</option>
        <option value="School name">School name</option>
        <option value="Nick name">Nick name</option>
        <option value="Favorite city">Favorite city</option>
        <option value="favorite team">favorite team</option>

    </select>

    <label for="hintAnswer">Hint Answer:</label>
    <input type="text" id="hintAnswer" name="hintAnswer" required>

    <button type="submit">Register</button>

    <footer>
        <p>&copy; 2023 : Prabhakar B K. All rights reserved.</p>
    </footer>
</form>



</body>
</html>































