from locust import HttpUser, between, task, tag


class ReactiveUser(HttpUser):
    
    host = "http://localhost:8082"
    wait_time = between(1,2)
    
    @task
    @tag("hello")
    def helloEndpoint(self):
        self.client.get("/WebClient/Hello");
    
    @task
    @tag("differentupstream")
    def testUpstreamFor200ms(self):
        self.client.get("/WebClient/Upstream/mock/execute")

    @task
    @tag("differentupstream")
    def testUpstreamFor400ms(self):
        self.client.get("/WebClient/Upstream/mock/400/execute")
    
    @task
    @tag("differentupstream")
    def testUpstreamFor800ms(self):
        self.client.get("/WebClient/Upstream/mock/800/execute")
    
    @task
    @tag("error")
    def testUpstreamFor2000ms(self):
        self.client.get("/WebClient/Upstream/mock/2000/execute")

    @task
    @tag("error")
    def testUpstreamFor404Status(self):
        self.client.get("/WebClient/Upstream/mock/200/execute/404")

    @task
    @tag("error")
    def testUpstreamFor500Status(self):
        self.client.get("/WebClient/Upstream/mock/200/execute/500")

    @task
    @tag("error")
    def testUpstreamFor503Status(self):
        self.client.get("/WebClient/Upstream/mock/200/execute/503")