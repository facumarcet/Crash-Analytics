const cron = require('node-cron');
const express = require('express');
const axios = require('axios');

const app = express();
cron.schedule('0 */1 * * * *', () => {
    axios.get('http://127.0.0.1:8000/api/scrapper').then(res => {
        console.log("Response: ", res.data);
    })
    .catch(err => {
        console.log("Err: ", err);
    });
});
app.listen(3000, () => {
    console.log("Server running on 3000")
});