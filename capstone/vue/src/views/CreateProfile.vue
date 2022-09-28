<template>
  <div id="createProfile">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <form class="profile-form" @submit.prevent="createProfile">
      <h1 class="cp">Create Profile</h1>
      <label for="fname">First Name</label>
      <input
        type="text"
        id="fname"
        class="form-control"
        name="firstName"
        placeholder="Your name.."
        v-model="profile.firstName"
      />

      <label for="lname">Last Name</label>
      <input
        type="text"
        id="lname"
        class="form-control"
        name="lastName"
        placeholder="Your last name.."
        v-model="profile.lastName"
      />

      <label for="email">Email Address </label>
      <input
        type="text"
        id="email"
        class="form-control"
        name="email"
        placeholder="Your email address"
        v-model="profile.emailAddress"
      />

      <select name="timezone" class="form-control" v-model="profile.timeZone">
        <option value="CDT">Central Daylight Time</option>
        <option value="EDT">Eastern Daylight Time</option>
        <option value="MDT">Mountain Daylight Time</option>
        <option value="MST">Mountain Standard Time</option>
        <option value="PDT">Pacific Daylight Time</option>
        <option value="ADT">Alaska Daylight Time</option>
        <option value="HST">Hawaii-Aleutian Standard Time</option>
      </select>

      <input
        type="checkbox"
        id="subscribe"
        class="form-control"
        name="subscribe"
        v-model="profile.subscribedToEmailList"
      />
      <label for="subscribedToEmailList">Subscribe to email list </label>

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Submit
      </button>
    </form>
  </div>
</template>

<script>
import Profile from "../services/CreateProfileService";
export default {
  name: "createProfile",
  data() {
    return {
      profile: {
        firstName: "",
        lastName: "",
        emailAddress: "",
        timeZone: "",
        subscribedToEmailList: false,
      },
    };
  },
  methods: {
    createProfile() {
      Profile.createProfile(this.profile)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push({
              name: "home",
            });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
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

label{
  color: white;
}
.cp{
 font-family: 'Poppins', sans-serif;
 color:#010130
}


#createProfile {
  width: 100%;
  /* background-color: #0525a8;
  color: orange; */
  padding: 20px 20px;
  margin: 20px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: white;
}

.profile-form {
  border-radius: 5px;
  background: linear-gradient(rgb(250, 130, 1), rgb(4, 38, 150));
  padding: 20px
  ;
  
}

button{
  display:inline-block;
padding:0.25em 1.2em;
border:0.1em solid #FFFFFF;
margin:0 0.3em 0.3em 0;
border-radius:0.12em;
box-sizing: border-box;
text-decoration:none;
font-family:'Georgia',sans-serif;
font-weight:300;
color:#06053b;
text-align:center;
transition: all 0.2s;
}
button:hover{
  color: #b95d07;
}
</style>