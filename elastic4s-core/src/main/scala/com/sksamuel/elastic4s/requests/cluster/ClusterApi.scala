package com.sksamuel.elastic4s.requests.cluster

trait ClusterApi {

  def clusterState(): ClusterStateRequest = ClusterStateRequest()
  def clusterStats()                      = new ClusterStatsRequest

  def nodeUsage(): NodeUsageRequest = NodeUsageRequest()
  def nodeHotThreads(): NodeHotThreadsRequest = NodeHotThreadsRequest()

  def clusterPersistentSettings(settings: Map[String, String]): ClusterSettingsRequest =
    ClusterSettingsRequest(settings, Map.empty)

  def clusterTransientSettings(settings: Map[String, String]): ClusterSettingsRequest =
    ClusterSettingsRequest(Map.empty, settings)

  def clusterHealth(): ClusterHealthRequest                             = clusterHealth("_all")
  def clusterHealth(first: String, rest: String*): ClusterHealthRequest = ClusterHealthRequest(first +: rest)
  def clusterHealth(indices: Iterable[String]): ClusterHealthRequest    = ClusterHealthRequest(indices.toIndexedSeq)
  def remoteClusterInfo() = RemoteClusterInfoRequest()
  def addRemoteClusterRequest(settings: Map[String, String]) = AddRemoteClusterSettingsRequest(clusterPersistentSettings(settings))
}
