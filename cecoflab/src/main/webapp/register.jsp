<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .form-container {
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    td {
        padding: 10px;
    }

   

   
    h1 {
        text-align: center;
        color: #333;
    }
</style>
</head>
<body>
<div class="form-container">
    <h1>Add Books</h1>
    <form action="register" method="post">
        <table>
            <tr>
                <td>Book  Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Author Name:</td>
                <td><input type="text" name="author"></td>
            </tr>
            <tr>
                <td>Book price:</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><input type="text" name="category"></td>
            </tr>
             <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="male"> Male
                    <input type="radio" name="gender" value="female"> Female
                </td>
            </tr>
            <tr>
                <td>Your Hobbies:</td>
                <td>
                    <input type="checkbox" name="hobbies" value="cricket"> Cricket
                    <input type="checkbox" name="hobbies" value="basketball"> Basketball
                    <input type="checkbox" name="hobbies" value="kabbadi"> Kabbadi
                    
                </td>
            </tr>
            
             <tr>
                <td>Country:</td>
                <td><select name=country>
                <option >Select Country</option>
             
                <option value="india">India</option>
                <option value="Pakistan">Pakistan</option>
                <option value="Usa">USA</option>
                
                
                </select></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" name="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
