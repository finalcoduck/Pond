importScripts('https://storage.googleapis.com/workbox-cdn/releases/3.5.0/workbox-sw.js');

if (workbox) {
  console.log(`Yay! Workbox is loaded 🎉`);

  workbox.precaching.precacheAndRoute([
	  {
	    "url": "build/general.css",
	    "revision":"c7a02441b4914ffdc39eb2eb55148adc"
	  }
	]);
    
  const articleHandler = workbox.strategies.networkFirst({
	    cacheName: 'articles-cache',
	    plugins: [
	      new workbox.expiration.Plugin({
	        maxEntries: 50,
	      })
	    ]
	  });
	  
	  workbox.routing.registerRoute('/', args => {
	    return articleHandler.handle(args);
	  });
	  const curriHandler = workbox.strategies.networkFirst({
		    cacheName: 'curri-cache',
		    plugins: [
		      new workbox.expiration.Plugin({
		        maxEntries: 50,
		      })
		    ]
		  });
		  
		  workbox.routing.registerRoute(/group\/curriculum/, args => {
		    return curriHandler.handle(args);
		  });
} else {
  console.log(`Boo! Workbox didn't load 😬`);
}