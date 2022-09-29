<template>
  <div id="createProfile">
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
      rel="stylesheet"
    />
    <form class="profile-form" @submit.prevent="createProfile">
      <h1 class="cp">Create Profile</h1>

      <ul>
        <li>
          <label for="fname">First Name</label>
          <input
            type="text"
            id="fname"
            class="form-control"
            name="firstName"
            placeholder="Your name.."
            v-model="profile.firstName"
          />
        </li>
        <li>
          <label for="lname">Last Name</label>
          <input
            type="text"
            id="lname"
            class="form-control"
            name="lastName"
            placeholder="Your last name.."
            v-model="profile.lastName"
          />
        </li>
        <li>
          <label for="email">Email Address </label>
          <input
            type="text"
            id="email"
            class="form-control"
            name="email"
            placeholder="Your email address"
            v-model="profile.emailAddress"
          />
        </li>
        <li>
          <label for="timezone">Time Zone </label>
          <select
            name="timezone"
            class="form-control"
            v-model="profile.timeZone"
          >
            <option value="" disabled selected hidden>Please select time zone</option>
            <option value="CDT">Central Daylight Time</option>
            <option value="EDT">Eastern Daylight Time</option>
            <option value="MDT">Mountain Daylight Time</option>
            <option value="MST">Mountain Standard Time</option>
            <option value="PDT">Pacific Daylight Time</option>
            <option value="ADT">Alaska Daylight Time</option>
            <option value="HST">Hawaii-Aleutian Standard Time</option>
          </select>
        </li>
        <li>
          <input
            type="checkbox"
            id="subscribe"
            class="form-control"
            name="subscribe"
            v-model="profile.subscribedToEmailList"
          />
          <label for="subscribedToEmailList" >Subscribe to email list </label>
        </li>
        <li>
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Submit
          </button>
        </li>
      </ul>
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
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap");


/* input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
} */


label {
  color: #ff6626;
  display: inline-block;
  width: 100px;
  margin: 10px;
  font-family: "Poppins", sans-serif;
  margin-left: 2px;

}
.cp {
  font-family: "Bebas Neue", sans-serif;
  font-size: 50px;
  font-weight: 9;
  color: #f24700;
  text-align: center;
}


input[type="text"] {
  padding: 5px;
  border: 0;
  box-shadow: 0 0 10px 2px #f24700;
}



input,textarea{
  width: 200px;
  box-sizing: border-box;
}

#createProfile {
  /* position: absolute;
        margin: 8% auto;
        min-height: 60%;
        width: 50%;
        box-shadow: 0 2px 16px rgba(0, 0, 0, 0.6);
        background: #010130;
        padding: 0px 0px 5px 15px;
        box-sizing: border-box;
        border-radius: 8px; */
 
 
 
 /* display: flex;
  align-items: center;
  justify-content: center;
  background-color: #ffffff;
  width: 100%;
  min-height: calc(100vh-74px);
  padding: 1; */

  
  /* width: 100%;
  /* background-color: #0525a8;
  color: orange; */
  /* padding: 20px 20px;
  margin: 20px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer; */ 
}

ul {
  list-style: none;
  padding: 20;
  margin: 30px;
  
 
}


input[type="submit"]:hover {
  background-color: white;
}

.profile-form {
position: relative;
width:400px;
height:600px;
background:#010130;
border-radius:8px;
box-shadow:0 0 40px -10px rgb(140, 140, 140);
margin:calc(50vh - 220px) auto;
padding:20px 30px; 
/* max-width:800px; */
box-sizing:border-box;



 /*margin: 0 auto;
  width: 500px;
  Form outline 
  padding: 2em;
   border: 2px inset #020262; 
  border-style:outset;
  border-radius: 4em; 
  border-color: #e6e6f1; */ 

  /* border-radius: 5px;
  background: linear-gradient(rgb(250, 130, 1), rgb(4, 38, 150));
  padding: 20px; */
}

button {
  display: inline-block;
  padding: 0.25em 1.2em;
  /* border: 0.1em solid #ffffff; */
  border: 0.1em;
  margin: 0 0.5em 0.5em 0;
  border-radius: 2px;
  box-sizing: border-box;
  text-decoration: none;
  text-transform: uppercase;
  font-family: "Poppins", sans-serif;
  font-weight: 300;
  color: #fafaff;
  background-color:  #f24700;
  text-align: center;
  transition: all 0.2s;
  margin-left: 8em;

}
button:hover {
  color: #b95d07;
}
</style>