/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDZGB2TQCdZCoVHJZpXl80wt9HjbyaDxfk",
  authDomain: "learning-tracking-4baf3.firebaseapp.com",
  databaseURL: "https://learning-tracking-4baf3-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "learning-tracking-4baf3",
  storageBucket: "learning-tracking-4baf3.appspot.com",
  messagingSenderId: "602675258529",
  appId: "1:602675258529:web:f6bd5728292e2f187fbce0",
  measurementId: "G-1NB7NE2B0J"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
