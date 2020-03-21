(defproject hello-pedestal-with-teamcity "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                  [io.pedestal/pedestal.service "0.5.7"]
                  [io.pedestal/pedestal.route "0.5.7"]
                  [io.pedestal/pedestal.jetty "0.5.7"]
                  [org.slf4j/slf4j-simple "1.7.28"]]
  :repositories [["central" "https://maven.aliyun.com/nexus/content/groups/public"]
                 ["clojars" "https://mirrors.tuna.tsinghua.edu.cn/clojars/"]]
  :main ^:skip-aot hello-pedestal-with-teamcity.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
