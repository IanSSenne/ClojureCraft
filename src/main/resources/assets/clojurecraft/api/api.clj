(defn get-block
    [x y z] (.getBlock com.teak1.clojurecraft.ClojureCraft/API x y z)
    )
(defn set-block
    [x y z block] (.setBlock com.teak1.clojurecraft.ClojureCraft/API x y z block)
)