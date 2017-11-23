# The World's Simplest Cloud Foundry App
_You can't get any easier than this!_

1. Create your Hello World! web page in your favorite test editor, name it `index.html` when you save it.

```
<!DOCTYPE html>
<html>
<head>
  <title>Hello</title>
</head>
<body>
  Hello World!
</body>
</html>
```

1. Push your web page app to Cloud Foundry.  

    From our within the directory containing the `index.html` run the command,

  `$ cf push hello -b staticfile_buildpack`

  _Note: Depending on which Cloud Foundry you deploy it too you may need to change the app name `hello` to something else since that name may already be taken_

  If you want to forgoe the explicit request to use the staticfile_buildpack just create an empty file called `Staticfile` in the same directory as 

Check your work by browsing to your new website, for instance if you used Pivotal Web Services (PWS) it would be http://hello.cfapps.io or the app name you choose to use, like http://worlds-simplest-cloud-foundry-app.cfapp.io

**Congratulations!** you have just built and deployed a static web page app.  _Too easy!_
