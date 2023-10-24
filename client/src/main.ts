const eventSource = new EventSource('http://localhost:8080/sse');
const div = document.getElementById('app');
console.log('div is ', div);
eventSource.onmessage = function (event) {
   // Do something with the event data
   console.log(event);
   if (div) {
      div.innerHTML = 'Receive event from backend ' + event.data;
   }
};

eventSource.onerror = function (error) {
   console.error(error);
};
