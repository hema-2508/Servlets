<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather Prediction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <h2 class="text-center text-primary mb-4">Weather Prediction Form</h2>

    <form action="move" method="post" class="row g-3">

        <div class="col-md-6">
            <label class="form-label">Place Name</label>
            <input type="text" name="pname" class="form-control" required>
        </div>

        <div class="col-md-6">
            <label class="form-label">Weather</label>
            <input type="text" name="weather" class="form-control" required>
        </div>

        <div class="col-md-6">
            <label class="form-label">Min Temp</label>
            <input type="number" name="mintemp" class="form-control" required>
        </div>

        <div class="col-md-6">
            <label class="form-label">Max Temp</label>
            <input type="number" name="maxtemp" class="form-control" required>
        </div>

        <div class="col-md-6">
            <label class="form-label">Cloudy</label>
            <select name="cloudy" class="form-select" required>
                <option value="" disabled selected>Select option</option>
                <option value="yes">Yes</option>
                <option value="no">No</option>
            </select>
        </div>

        <div class="col-md-6">
            <label class="form-label">Raining</label>
            <select name="raining" class="form-select" required>
                <option value="" disabled selected>Select option</option>
                <option value="yes">Yes</option>
                <option value="no">No</option>
            </select>
        </div>


        <div class="col-md-6">
            <label class="form-label">Humidity</label>
            <input type="text" name="humidity" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Wind Speed</label>
            <input type="text" name="windspeed" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Sun Rise Time</label>
            <input type="time" name="sunrisetime" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Sun Set Time</label>
            <input type="time" name="sunsettime" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Moon Rise Time</label>
            <input type="time" name="moonrisetime" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Moon Set Time</label>
            <input type="time" name="moonsettime" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Rain Start Time</label>
            <input type="time" name="rainstarttime" class="form-control">
        </div>

        <div class="col-md-6">
            <label class="form-label">Rain End Time</label>
            <input type="time" name="rainendtime" class="form-control">
        </div>

        <div class="col-md-12">
            <label class="form-label">Precipitation</label>
            <input type="text" name="precipitation" class="form-control">
        </div>

        <div class="col-12 text-center mt-4">
            <input type="submit" value="Check" class="btn btn-success btn-lg px-5">
        </div>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
