package speedith.core.lang

import scala.collection.JavaConversions.{setAsJavaSet, asJavaCollection, iterableAsScalaIterable, asScalaSet}
import propity.util.Sets

case class Region(zones: Set[Zone]) extends Comparable[Region] {

  val getZones: java.util.SortedSet[Zone] = {
    new java.util.TreeSet[Zone](setAsJavaSet(zones))
  }

  def this(zones: java.util.Set[Zone]) = {
    this(if (zones == null) Set.empty[Zone] else asScalaSet(zones).toSet)
  }

  def this(zones: java.util.Collection[Zone]) = {
    this(if (zones == null) Set.empty[Zone] else iterableAsScalaIterable(zones).toSet)
  }

  def this() = {
    this(Set.empty)
  }

  def this(zone1: Zone) = {
    this(Set(zone1))
  }

  def this(zone1: Zone, zone2: Zone) = {
    this(Set(zone1, zone2))
  }

  def this(zone1: Zone, zone2: Zone, zone3: Zone) = {
    this(Set(zone1, zone2, zone3))
  }

  def this(zone1: Zone, zone2: Zone, zone3: Zone, zone4: Zone) = {
    this(Set(zone1, zone2, zone3, zone4))
  }

  def this(zone1: Zone, zone2: Zone, zone3: Zone, zone4: Zone, otherZones: Zone*) = {
    this(Set(zone1, zone2, zone3, zone4) ++ otherZones)
  }

  def isSubregionOf(otherRegion: Region): Boolean = {
    zones.subsetOf(otherRegion.zones)
  }

  def contains(zone: Zone): Boolean = {
    zones.contains(zone)
  }

  def toString(stringBuilder: Appendable): Appendable = {
    SpiderDiagram.printZoneList(stringBuilder, asJavaCollection(zones))
    stringBuilder
  }

  def getZonesCount: Int = {
    zones.size
  }

  def union(otherRegion: Region): Region = {
    Region(zones.union(otherRegion.zones))
  }

  def subtract(otherRegion: Region): Region = {
    Region(zones -- otherRegion.zones)
  }

  def compareTo(otherRegion: Region): Int = {
    Sets.compareNaturally(getZones, otherRegion.getZones)
  }
}