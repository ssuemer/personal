package pprogtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pprog.Tools;


class ToolsTest {

	@Test
	void testPartitionData() {
		for (int length = 5; length <= 1000; length += 5) {
			for (int numPartitions = 1; numPartitions <= length + 5; numPartitions++) {
				Tools.ArraySplit[] partition = Tools.PartitionData(length, numPartitions);
				assertEquals(numPartitions, partition.length);
				int start = 0;
				for (int i = 0; i < partition.length; i++) {
					assertEquals(start, partition[i].startIndex);
					start += partition[i].length;
				}
				assertEquals(start,length);
			}
		}
	}


}
