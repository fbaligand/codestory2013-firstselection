package codestory.resource;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

import codestory.bean.BestPlanning;

public class JajascriptResourceTest {
	
	private JajascriptResource jajascriptResource = new JajascriptResource();

	@Test
	public void testProcessOptimizeChallenge1() {
		String request = "[{\"VOL\":\"MONAD42\",\"DEPART\":0,\"DUREE\":5,\"PRIX\":10},{\"VOL\":\"META18\",\"DEPART\":3,\"DUREE\":7,\"PRIX\":14},{\"VOL\":\"LEGACY01\",\"DEPART\":5,\"DUREE\":9,\"PRIX\":8},{\"VOL\":\"YAGNI17\",\"DEPART\":5,\"DUREE\":9,\"PRIX\":7}]";
		
		BestPlanning bestPlanning = jajascriptResource.processOptimize(request);
		
		assertEquals(18, bestPlanning.getGain());
		assertEquals(2, bestPlanning.getPathSize());
	}
	
	@Test
	public void testProcessOptimizeChallenge2() {
		String request = "[ { \"VOL\": \"thankful-backup-54\", \"DEPART\": 3, \"DUREE\": 7, \"PRIX\": 22 }, { \"VOL\": \"happy-vaseline-55\", \"DEPART\": 2, \"DUREE\": 4, \"PRIX\": 5 }, { \"VOL\": \"whispering-muzzle-93\", \"DEPART\": 4, \"DUREE\": 3, \"PRIX\": 6 }, { \"VOL\": \"ashamed-punk-17\", \"DEPART\": 4, \"DUREE\": 2, \"PRIX\": 10 }, { \"VOL\": \"outrageous-trauma-43\", \"DEPART\": 3, \"DUREE\": 3, \"PRIX\": 5 }, { \"VOL\": \"sleepy-sunlamp-81\", \"DEPART\": 7, \"DUREE\": 2, \"PRIX\": 19 }, { \"VOL\": \"Early-chimpanzee-56\", \"DEPART\": 7, \"DUREE\": 1, \"PRIX\": 16 }, { \"VOL\": \"testy-teeth-33\", \"DEPART\": 8, \"DUREE\": 10, \"PRIX\": 7 }, { \"VOL\": \"cute-mafioso-36\", \"DEPART\": 5, \"DUREE\": 9, \"PRIX\": 14 }, { \"VOL\": \"open-clerk-69\", \"DEPART\": 9, \"DUREE\": 1, \"PRIX\": 7 }, { \"VOL\": \"clumsy-gnu-48\", \"DEPART\": 11, \"DUREE\": 5, \"PRIX\": 12 }, { \"VOL\": \"enthusiastic-cranium-90\", \"DEPART\": 11, \"DUREE\": 7, \"PRIX\": 21 }, { \"VOL\": \"blue-runner-41\", \"DEPART\": 10, \"DUREE\": 9, \"PRIX\": 6 }, { \"VOL\": \"funny-hockey-74\", \"DEPART\": 13, \"DUREE\": 8, \"PRIX\": 8 }, { \"VOL\": \"wild-mocha-1\", \"DEPART\": 14, \"DUREE\": 15, \"PRIX\": 7 } ]";
		
		BestPlanning bestPlanning = jajascriptResource.processOptimize(request);
		
		assertEquals(57, bestPlanning.getGain());
		assertEquals(4, bestPlanning.getPathSize());
	}

	@Test
	public void testProcessOptimizeChallenge3() {
		String request = "[ { \"VOL\": \"condemned-burglar-98\", \"DEPART\": 4, \"DUREE\": 2, \"PRIX\": 14 }, { \"VOL\": \"confused-washer-68\", \"DEPART\": 4, \"DUREE\": 7, \"PRIX\": 16 }, { \"VOL\": \"crowded-shoulder-73\", \"DEPART\": 1, \"DUREE\": 4, \"PRIX\": 7 }, { \"VOL\": \"annoying-pebble-59\", \"DEPART\": 1, \"DUREE\": 1, \"PRIX\": 8 }, { \"VOL\": \"courageous-preschooler-56\", \"DEPART\": 2, \"DUREE\": 4, \"PRIX\": 5 }, { \"VOL\": \"sparkling-swag-26\", \"DEPART\": 6, \"DUREE\": 5, \"PRIX\": 23 }, { \"VOL\": \"enchanting-ventilator-40\", \"DEPART\": 7, \"DUREE\": 2, \"PRIX\": 10 }, { \"VOL\": \"immense-brass-55\", \"DEPART\": 8, \"DUREE\": 10, \"PRIX\": 3 }, { \"VOL\": \"awful-bait-49\", \"DEPART\": 6, \"DUREE\": 5, \"PRIX\": 14 }, { \"VOL\": \"massive-applause-76\", \"DEPART\": 5, \"DUREE\": 12, \"PRIX\": 4 }, { \"VOL\": \"funny-hatchback-31\", \"DEPART\": 10, \"DUREE\": 4, \"PRIX\": 5 }, { \"VOL\": \"nice-tide-24\", \"DEPART\": 13, \"DUREE\": 1, \"PRIX\": 4 }, { \"VOL\": \"crazy-tricycle-79\", \"DEPART\": 10, \"DUREE\": 2, \"PRIX\": 4 }, { \"VOL\": \"upset-dune-13\", \"DEPART\": 12, \"DUREE\": 8, \"PRIX\": 11 }, { \"VOL\": \"poor-pidgin-43\", \"DEPART\": 12, \"DUREE\": 12, \"PRIX\": 2 }, { \"VOL\": \"lazy-stepmother-24\", \"DEPART\": 16, \"DUREE\": 7, \"PRIX\": 26 }, { \"VOL\": \"ugly-southerner-73\", \"DEPART\": 18, \"DUREE\": 6, \"PRIX\": 10 }, { \"VOL\": \"deep-witch-23\", \"DEPART\": 18, \"DUREE\": 9, \"PRIX\": 1 }, { \"VOL\": \"tender-ceremony-5\", \"DEPART\": 17, \"DUREE\": 6, \"PRIX\": 11 }, { \"VOL\": \"tender-width-71\", \"DEPART\": 16, \"DUREE\": 10, \"PRIX\": 5 }, { \"VOL\": \"jittery-turpentine-72\", \"DEPART\": 20, \"DUREE\": 2, \"PRIX\": 20 }, { \"VOL\": \"evil-slowpoke-84\", \"DEPART\": 22, \"DUREE\": 5, \"PRIX\": 16 }, { \"VOL\": \"lively-server-14\", \"DEPART\": 23, \"DUREE\": 1, \"PRIX\": 7 }, { \"VOL\": \"grieving-sextant-73\", \"DEPART\": 22, \"DUREE\": 2, \"PRIX\": 14 }, { \"VOL\": \"important-wastebasket-74\", \"DEPART\": 22, \"DUREE\": 1, \"PRIX\": 4 }, { \"VOL\": \"frail-shorts-50\", \"DEPART\": 28, \"DUREE\": 4, \"PRIX\": 11 }, { \"VOL\": \"clumsy-curl-36\", \"DEPART\": 25, \"DUREE\": 4, \"PRIX\": 19 }, { \"VOL\": \"zealous-beech-47\", \"DEPART\": 26, \"DUREE\": 1, \"PRIX\": 8 }, { \"VOL\": \"defeated-children-64\", \"DEPART\": 28, \"DUREE\": 8, \"PRIX\": 6 }, { \"VOL\": \"poor-below-77\", \"DEPART\": 27, \"DUREE\": 16, \"PRIX\": 7 }, { \"VOL\": \"shallow-college-82\", \"DEPART\": 34, \"DUREE\": 8, \"PRIX\": 4 }, { \"VOL\": \"massive-weaponry-18\", \"DEPART\": 30, \"DUREE\": 9, \"PRIX\": 15 }, { \"VOL\": \"helpless-road-61\", \"DEPART\": 31, \"DUREE\": 7, \"PRIX\": 9 }, { \"VOL\": \"amused-level-92\", \"DEPART\": 30, \"DUREE\": 7, \"PRIX\": 10 }, { \"VOL\": \"nice-mussel-84\", \"DEPART\": 31, \"DUREE\": 6, \"PRIX\": 4 }, { \"VOL\": \"raspy-slum-19\", \"DEPART\": 37, \"DUREE\": 10, \"PRIX\": 4 }, { \"VOL\": \"scary-macaroni-47\", \"DEPART\": 36, \"DUREE\": 4, \"PRIX\": 23 }, { \"VOL\": \"frantic-silicon-14\", \"DEPART\": 39, \"DUREE\": 10, \"PRIX\": 8 }, { \"VOL\": \"cooing-sometimes-32\", \"DEPART\": 39, \"DUREE\": 2, \"PRIX\": 8 }, { \"VOL\": \"crowded-symbolism-93\", \"DEPART\": 39, \"DUREE\": 9, \"PRIX\": 3 }, { \"VOL\": \"crowded-sea-27\", \"DEPART\": 43, \"DUREE\": 8, \"PRIX\": 21 }, { \"VOL\": \"impossible-tongs-74\", \"DEPART\": 40, \"DUREE\": 6, \"PRIX\": 15 }, { \"VOL\": \"scrawny-hillbilly-14\", \"DEPART\": 43, \"DUREE\": 9, \"PRIX\": 8 }, { \"VOL\": \"resonant-utensil-72\", \"DEPART\": 43, \"DUREE\": 6, \"PRIX\": 9 }, { \"VOL\": \"drab-fluid-91\", \"DEPART\": 44, \"DUREE\": 2, \"PRIX\": 1 }, { \"VOL\": \"brave-dolphin-4\", \"DEPART\": 46, \"DUREE\": 10, \"PRIX\": 4 }, { \"VOL\": \"mushy-soreness-19\", \"DEPART\": 45, \"DUREE\": 8, \"PRIX\": 23 }, { \"VOL\": \"blue-eyed-cap-64\", \"DEPART\": 45, \"DUREE\": 4, \"PRIX\": 7 }, { \"VOL\": \"bored-dove-89\", \"DEPART\": 45, \"DUREE\": 4, \"PRIX\": 10 }, { \"VOL\": \"encouraging-goatherd-32\", \"DEPART\": 47, \"DUREE\": 12, \"PRIX\": 4 }, { \"VOL\": \"cheerful-panel-59\", \"DEPART\": 52, \"DUREE\": 6, \"PRIX\": 13 }, { \"VOL\": \"dull-goat-31\", \"DEPART\": 54, \"DUREE\": 8, \"PRIX\": 22 }, { \"VOL\": \"successful-mango-57\", \"DEPART\": 50, \"DUREE\": 9, \"PRIX\": 9 }, { \"VOL\": \"bewildered-flapjack-3\", \"DEPART\": 53, \"DUREE\": 1, \"PRIX\": 8 }, { \"VOL\": \"horrible-back-1\", \"DEPART\": 54, \"DUREE\": 8, \"PRIX\": 2 }, { \"VOL\": \"happy-sequence-72\", \"DEPART\": 58, \"DUREE\": 2, \"PRIX\": 25 }, { \"VOL\": \"good-semicolon-47\", \"DEPART\": 57, \"DUREE\": 3, \"PRIX\": 15 }, { \"VOL\": \"thankful-warmonger-5\", \"DEPART\": 57, \"DUREE\": 4, \"PRIX\": 7 }, { \"VOL\": \"outrageous-gymnastics-72\", \"DEPART\": 55, \"DUREE\": 8, \"PRIX\": 13 }, { \"VOL\": \"breakable-crossbow-39\", \"DEPART\": 55, \"DUREE\": 11, \"PRIX\": 5 } ]";
		
		BestPlanning bestPlanning = jajascriptResource.processOptimize(request);
		
		assertEquals(191, bestPlanning.getGain());
		assertEquals(12, bestPlanning.getPathSize());
	}
	
	@Test
	public void testProcessOptimizeChallenge4() {
		String request = "[ { \"VOL\": \"inquisitive-salmonella-78\", \"DEPART\": 3, \"DUREE\": 6, \"PRIX\": 25 }, { \"VOL\": \"crazy-skateboard-46\", \"DEPART\": 1, \"DUREE\": 6, \"PRIX\": 16 }, { \"VOL\": \"evil-loudspeaker-25\", \"DEPART\": 3, \"DUREE\": 3, \"PRIX\": 9 }, { \"VOL\": \"dizzy-doughnut-12\", \"DEPART\": 4, \"DUREE\": 8, \"PRIX\": 8 }, { \"VOL\": \"colossal-stockade-88\", \"DEPART\": 0, \"DUREE\": 6, \"PRIX\": 2 }, { \"VOL\": \"faint-gynecologist-17\", \"DEPART\": 5, \"DUREE\": 1, \"PRIX\": 5 }, { \"VOL\": \"easy-warfare-75\", \"DEPART\": 7, \"DUREE\": 4, \"PRIX\": 4 }, { \"VOL\": \"odd-simulator-19\", \"DEPART\": 9, \"DUREE\": 1, \"PRIX\": 6 }, { \"VOL\": \"black-package-47\", \"DEPART\": 6, \"DUREE\": 2, \"PRIX\": 9 }, { \"VOL\": \"wild-arcade-9\", \"DEPART\": 9, \"DUREE\": 4, \"PRIX\": 5 }, { \"VOL\": \"dizzy-peekaboo-6\", \"DEPART\": 13, \"DUREE\": 6, \"PRIX\": 13 }, { \"VOL\": \"beautiful-elevator-91\", \"DEPART\": 13, \"DUREE\": 10, \"PRIX\": 15 }, { \"VOL\": \"miniature-rioter-56\", \"DEPART\": 10, \"DUREE\": 1, \"PRIX\": 5 }, { \"VOL\": \"steep-mussel-8\", \"DEPART\": 11, \"DUREE\": 3, \"PRIX\": 8 }, { \"VOL\": \"ugly-temperature-33\", \"DEPART\": 12, \"DUREE\": 18, \"PRIX\": 7 }, { \"VOL\": \"strange-pasta-94\", \"DEPART\": 19, \"DUREE\": 8, \"PRIX\": 26 }, { \"VOL\": \"gorgeous-wafer-50\", \"DEPART\": 17, \"DUREE\": 5, \"PRIX\": 7 }, { \"VOL\": \"bright-spoon-79\", \"DEPART\": 15, \"DUREE\": 5, \"PRIX\": 8 }, { \"VOL\": \"wide-eyed-fingertip-69\", \"DEPART\": 17, \"DUREE\": 7, \"PRIX\": 9 }, { \"VOL\": \"magnificent-cigarette-4\", \"DEPART\": 16, \"DUREE\": 8, \"PRIX\": 5 }, { \"VOL\": \"brainy-blackjack-55\", \"DEPART\": 21, \"DUREE\": 10, \"PRIX\": 5 }, { \"VOL\": \"successful-mountaineer-54\", \"DEPART\": 23, \"DUREE\": 10, \"PRIX\": 21 }, { \"VOL\": \"prickly-raffle-7\", \"DEPART\": 24, \"DUREE\": 4, \"PRIX\": 3 }, { \"VOL\": \"long-raft-75\", \"DEPART\": 20, \"DUREE\": 7, \"PRIX\": 14 }, { \"VOL\": \"upset-topic-59\", \"DEPART\": 21, \"DUREE\": 13, \"PRIX\": 6 }, { \"VOL\": \"difficult-pair-79\", \"DEPART\": 25, \"DUREE\": 8, \"PRIX\": 5 }, { \"VOL\": \"short-dream-84\", \"DEPART\": 29, \"DUREE\": 2, \"PRIX\": 9 }, { \"VOL\": \"large-orangutan-58\", \"DEPART\": 28, \"DUREE\": 7, \"PRIX\": 1 }, { \"VOL\": \"fair-casket-36\", \"DEPART\": 29, \"DUREE\": 9, \"PRIX\": 13 }, { \"VOL\": \"troubled-watermelon-31\", \"DEPART\": 27, \"DUREE\": 8, \"PRIX\": 4 }, { \"VOL\": \"ancient-sandwich-26\", \"DEPART\": 32, \"DUREE\": 6, \"PRIX\": 3 }, { \"VOL\": \"long-farmer-27\", \"DEPART\": 33, \"DUREE\": 10, \"PRIX\": 15 }, { \"VOL\": \"fierce-cabinetmaker-12\", \"DEPART\": 32, \"DUREE\": 6, \"PRIX\": 6 }, { \"VOL\": \"famous-stitch-76\", \"DEPART\": 30, \"DUREE\": 8, \"PRIX\": 12 }, { \"VOL\": \"doubtful-kicker-14\", \"DEPART\": 30, \"DUREE\": 14, \"PRIX\": 7 }, { \"VOL\": \"tall-pie-21\", \"DEPART\": 38, \"DUREE\": 10, \"PRIX\": 7 }, { \"VOL\": \"healthy-uterus-35\", \"DEPART\": 35, \"DUREE\": 4, \"PRIX\": 21 }, { \"VOL\": \"naughty-bifocal-73\", \"DEPART\": 35, \"DUREE\": 5, \"PRIX\": 2 }, { \"VOL\": \"wrong-oat-88\", \"DEPART\": 37, \"DUREE\": 4, \"PRIX\": 6 }, { \"VOL\": \"light-yokel-75\", \"DEPART\": 37, \"DUREE\": 8, \"PRIX\": 3 }, { \"VOL\": \"fancy-sheepskin-3\", \"DEPART\": 43, \"DUREE\": 7, \"PRIX\": 26 }, { \"VOL\": \"cruel-searcher-97\", \"DEPART\": 42, \"DUREE\": 8, \"PRIX\": 14 }, { \"VOL\": \"difficult-rakish-28\", \"DEPART\": 44, \"DUREE\": 7, \"PRIX\": 8 }, { \"VOL\": \"thankful-loudmouth-86\", \"DEPART\": 44, \"DUREE\": 6, \"PRIX\": 12 }, { \"VOL\": \"hungry-horseshoe-93\", \"DEPART\": 43, \"DUREE\": 17, \"PRIX\": 4 }, { \"VOL\": \"brief-jaguar-3\", \"DEPART\": 47, \"DUREE\": 10, \"PRIX\": 6 }, { \"VOL\": \"eager-values-43\", \"DEPART\": 48, \"DUREE\": 10, \"PRIX\": 19 }, { \"VOL\": \"testy-pumpernickel-92\", \"DEPART\": 48, \"DUREE\": 9, \"PRIX\": 1 }, { \"VOL\": \"spotless-balm-94\", \"DEPART\": 47, \"DUREE\": 6, \"PRIX\": 11 }, { \"VOL\": \"gorgeous-pinkeye-4\", \"DEPART\": 45, \"DUREE\": 14, \"PRIX\": 4 }, { \"VOL\": \"uninterested-tweet-88\", \"DEPART\": 51, \"DUREE\": 4, \"PRIX\": 1 }, { \"VOL\": \"thoughtless-raisin-12\", \"DEPART\": 53, \"DUREE\": 10, \"PRIX\": 6 }, { \"VOL\": \"nutty-therapist-85\", \"DEPART\": 53, \"DUREE\": 3, \"PRIX\": 6 }, { \"VOL\": \"gigantic-saxophonist-39\", \"DEPART\": 50, \"DUREE\": 5, \"PRIX\": 6 }, { \"VOL\": \"homeless-gem-61\", \"DEPART\": 53, \"DUREE\": 2, \"PRIX\": 7 } ]";
		
		BestPlanning bestPlanning = jajascriptResource.processOptimize(request);
		
		assertEquals(138, bestPlanning.getGain());
		assertEquals(9, bestPlanning.getPathSize());
	}

	@Test
	public void testProcessOptimizeChallenge50000() throws IOException {

		StringBuilder requestBuilder = new StringBuilder();
		InputStream inputJsonStream = this.getClass().getResourceAsStream("/jajascript50000.json");
		Reader inputJsonReader = new InputStreamReader(inputJsonStream);
		char[] buffer = new char[4096];
		int bufferSize;
		
		while ( (bufferSize = inputJsonReader.read(buffer)) != -1) {
			requestBuilder.append(buffer, 0, bufferSize);
		}
		
		String request = requestBuilder.toString();
		
		BestPlanning bestPlanning = jajascriptResource.processOptimize(request);
		
		assertEquals(168267, bestPlanning.getGain());
	}

	@Test
	public void testProcessOptimizeChallenge50000_2() throws IOException {

		StringBuilder requestBuilder = new StringBuilder();
		InputStream inputJsonStream = this.getClass().getResourceAsStream("/jajascript50000_2.json");
		Reader inputJsonReader = new InputStreamReader(inputJsonStream);
		char[] buffer = new char[4096];
		int bufferSize;
		
		while ( (bufferSize = inputJsonReader.read(buffer)) != -1) {
			requestBuilder.append(buffer, 0, bufferSize);
		}
		
		String request = requestBuilder.toString();
		
		BestPlanning bestPlanning = jajascriptResource.processOptimize(request);
		
		assertEquals(168128, bestPlanning.getGain());
	}
}
