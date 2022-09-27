<template>
  <div
    id="createProfile">
    <form class="profile-form" @submit.prevent="create">
      <h1 class="h3 mb-3 font-weight-normal">Create Profile</h1>
      <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" placeholder="Your last name..">

    <label for= "email">Email Address </label>
    <input type="text" id="email" name="email" placeholder="Your email address">

    <select name ="timezone">
      <option value= "Central Daylight Time">Central Daylight Time</option>
      <option value= "Eastern Daylight Time">Central Daylight Time</option>
      <option value= "Mountain Daylight Time">Central Daylight Time</option>
      <option value= "Mountain Standard Time">Central Daylight Time</option>
      <option value= "Pacific Daylight Time">Central Daylight Time</option>
      <option value= "Alaska Daylight Time">Central Daylight Time</option>
      <option value= "Hawaii-Aleutian Standard Time">Central Daylight Time</option>
  </select>

  <input type="checkbox" id="subscribe" name="subscribe" >
  <label for= "subscribe">Subscribe to email list </label>

  <input type="submit" value="Submit">
  </form>


</div>
</template>

<script>
import authService from '../services/AuthService';
export default {
name: 'createProfile',
data(){
  return{
    profile:{
      firstName: "",
      lastName: "",
      email:  "",
      timezone: "",
      subscribe: false

    }
  }
},
methods:{
  createProfile(){
    authService.createProfile(this.profile).then((response) => {
      if(response.status == 201) {
          this.$router.push({
            path:'/login'
          })
      }
    })

  }
}
}
</script>

<style>
/* input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
} */

#createProfile{
  width: 100%;
  background-color: #0525a8;
  color: orange;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: white;
}

.profile-form{
  border-radius: 5px;
  background:linear-gradient(rgba(192, 107, 28, 0.933),rgba(18, 13, 126, 0.933));
  padding: 20px;
}


</style>