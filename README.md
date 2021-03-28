# java-k8s
Build and Deploy Optimized App.

## Reactive for better resource utilization
* Why Reactive?
  * Thread, async
  * Optimized to run in cloud
  * ~~Funny Money~~ 
* Project Reactor
  * Servlet --> Webflux
  * Tomcat --> Netty
  * JDBC --> R2DBC
    
## Demo the project.
* Develop Locally
  * Explain application functionality
  * Show readiness and liveliness
    * Application knows when it is not working correctly
  * Show Stream 
  * Show Triggering of app down, and graceful exit
* Run in Google Cloud
  * Build
    * Docker vs Buildpacks
  * Deploy 
  * Config
  * Run
  * Repeat of the functionality and app behavior
  
## Road Ahead - Serverless
* Serverless (Lambda/Cloud Functions)
  * managed by cloud providers (startup/shutdown)
  * Billed by milli-secs
* Problem with Java in Cloud
  * Build time vs Run time 
  * Memory Footprint
  * Dependency Injection, class loader, proxies
* How to Lower these ^^?
  * Scripting Language Frameworks
    * Serverless framework (Demo if time permits.)
  * Rethink JVM
    * Demo of running in GraalVM (if time permits)
  * Rethink Framework
    * Micronaut
  
## Q&A
