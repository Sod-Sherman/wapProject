package edu.mum.wap.socialnetwork.repository.impl;

import edu.mum.wap.socialnetwork.model.*;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.UserRepository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class PostRepositoryImpl implements PostRepository {
    private List<Post> posts;
    private static final PostRepositoryImpl INSTANCE = new PostRepositoryImpl();

    public static PostRepositoryImpl getInstance() {
        return INSTANCE;
    }

    private PostRepositoryImpl() {
        UserRepository userRepository = UserRepositoryImpl.getInstance();
        User sod = userRepository.findByUsername("sod");
        User tur = userRepository.findByUsername("tur");
        User puujgee = userRepository.findByUsername("puujgee");

        Post sodPost = new Post("JavaScript.com is a resource built by the Pluralsight team for the JavaScript community.\n" +
                "\n" +
                "Because JavaScript is a great language for coding beginners, we've gathered some of the best learning resources around and built a JavaScript course to help new developers get up and running.\n" +
                "\n" +
                "With the help of community members contributing content to the site, JavaScript.com aims to also keep more advanced developers up to date on news, frameworks, and libraries.",
                LocalDate.of(2019, 8, 30), "", sod);

        Post sodPost1 = new Post("The docuseries about my life and work is out today. I hope you’ll check it out on Netflix — and then read some of the stories that didn’t make the cut on my blog.",
                LocalDate.of(2019, 8, 31), "images/post/safe_image.jpg", sod);

        Post sodPost2 = new Post("A whistleblower complaint, which includes allegations about President Trump's conduct, was hand-delivered to Capitol Hill this afternoon for lawmakers to review.\n" +
                "Few details have been released about the complaint, which was reviewed by lawmakers in a secured room..",
                LocalDate.of(2019, 7, 28), "images/post/whitehouse.jpg", sod);

        Post sodPost3 = new Post("Donald Trump pressed the Ukrainian president to work with the US attorney general to investigate his political rival Joe Biden, a damning White House memo revealed on Wednesday, raising the stakes in an acrimonious and polarising impeachment inquiry..",
                LocalDate.of(2019, 8, 30), "https://www.theguardian.com/us-news/2019/sep/25/ukraine-trump-meeting-impeachment-inquiry-whistleblower-conversation#img-1", sod);

        Post sodPost4 = new Post("Almost 21,000 people rushed out to buy a copy of David Cameron’s memoir in its first week on sale, placing it second on the latest book charts to Margaret Atwood’s The Testaments and, historically, behind Margaret Thatcher and Tony Blair for the title of fastest-selling political memoir by a former prime minister.",
                LocalDate.of(2019, 8, 29), "https://www.theguardian.com/books/2019/sep/24/david-cameron-memoir-margaret-atwood-dystopia-for-the-record#img-1", sod);

        Post turPost = new Post("Today, one of the biggest challenges facing Alzheimer’s researchers is finding patients who can benefit from novel therapies before it’s too late. AI is showing a lot of promise in helping to detect Alzheimer’s far earlier than current methods. I'm eager to see how it could change how we better understand and fight the disease.",
                LocalDate.of(2019, 9, 10), "https://external-ort2-1.xx.fbcdn.net/safe_image.php?d=AQCBV-qYsqZM5Hy7&w=540&h=282&url=https%3A%2F%2Fwww.statnews.com%2Fwp-content%2Fuploads%2F2019%2F08%2Fdom-brain-1024x576.jpg&cfs=1&upscale=1&fallback=news_d_placeholder_publisher&_nc_hash=AQAF-ZJxpLw_rgYI", tur);

        Post turPost1 = new Post("The docuseries about my life and work is out today. I hope you’ll check it out on Netflix — and then read some of the stories that didn’t make the cut on my blog.",
                LocalDate.of(2019, 8, 31), "images/post/safe_image.jpg", tur);

        Post turPost2 = new Post("Just 1% of English residents are responsible for nearly a fifth of all flights abroad, according to previously unpublished statistics.",
                LocalDate.of(2019, 7, 28), "https://www.theguardian.com/environment/2019/sep/25/1-of-english-residents-take-one-fifth-of-overseas-flights-survey-shows#img-1", tur);

        Post turPost3 = new Post("The all-action football sim includes a superb new six-a-side Volta mode and the controversial, pay-for Ultimate Team. There’s a question mark stalking EA’s football series with the unshakeable tenacity of Fabio Cannavaro in his prime.",
                LocalDate.of(2019, 8, 30), "https://www.theguardian.com/games/2019/sep/25/fifa-20-review-not-your-typical-annual-update#img-1", tur);

        Post turPost4 = new Post("Peel and finely chop 4 cloves of garlic. Peel a 4cm knob of ginger and cut it into fine matchstick-sized shreds. Halve, seed and finely chop 4 small, hot, red chillies. Finely chop 4 spring onions, discarding any dark or tough shoots.",
                LocalDate.of(2019, 8, 29), "https://www.theguardian.com/food/2019/sep/24/nigel-slater-mushrooms-with-ginger-and-coriander-recipe#img-1", tur);

        Post puujgeePost = new Post("Whenever I hear an idea for what we can do to keep global warming in check—whether it’s over a conference table or a cheeseburger—I always ask this question: “What’s your plan for steel?” I know it sounds like an odd thing to say, but it opens the door to an important subject.",
                LocalDate.of(2019, 9, 22), "https://external-ort2-1.xx.fbcdn.net/safe_image.php?d=AQAl4W7u2Re62WqJ&w=540&h=282&url=https%3A%2F%2Fwww.gatesnotes.com%2F-%2Fmedia%2FImages%2FArticles%2FEnergy%2FA-question-to-ask-about-every-climate-plan%2Fenergy-manufacturing_2019_article-hero_1200px_v2.jpg&cfs=1&upscale=1&fallback=news_d_placeholder_publisher&_nc_hash=AQCGwLSvFlNlfwhe", puujgee);

        Post puujgeePost1 = new Post("Zlatan is one of the best strikers of his generation, yet for many Zlatan Ibrahimovic is defined by what he says off the pitch rather than what he produces on it. Never before has this been truer than it is now. The Swede’s hat-trick against Sporting KC last week saw him break LA Galaxy’s single-season scoring record, and he now has 27 goals in 26 games. But that still doesn’t do justice to the way Ibrahimovic has affected the narrative in Major League Soccer this season..",
                LocalDate.of(2019, 9, 23), "https://www.theguardian.com/football/2019/sep/25/how-ibrahimovic-and-rooney-became-advocates-for-mls-players-rights#img-1", puujgee);

        Post puujgeePost2 = new Post("Zlatan is one of the best strikers of his generation, yet for many Zlatan Ibrahimovic is defined by what he says off the pitch rather than what he produces on it. Never before has this been truer than it is now. The Swede’s hat-trick against Sporting KC last week saw him break LA Galaxy’s single-season scoring record, and he now has 27 goals in 26 games. But that still doesn’t do justice to the way Ibrahimovic has affected the narrative in Major League Soccer this season..",
                LocalDate.of(2019, 9, 23), "https://www.theguardian.com/football/2019/sep/25/how-ibrahimovic-and-rooney-became-advocates-for-mls-players-rights#img-1", puujgee);

        Post puujgeePost3 = new Post("Caving in to apparently nonexistent demands for a competition football fans were unaware they needed, European football’s governing body has announced a new wheeze due to kick off in 2021.",
                LocalDate.of(2019, 9, 24), "https://www.theguardian.com/football/2019/sep/25/uefa-europa-conference-league-big-fish-happy#img-1", puujgee);

        Post puujgeePost4 = new Post("The Des Moines Register-CNN-Mediacom Iowa poll – the gold standard of polling – gave the strongest indication yet when it reported Saturday that Warren has 22% support of likely Iowa caucus-goers, while Joe Biden has 20% and Bernie Sanders 11%.",
                LocalDate.of(2019, 3, 26), "https://www.theguardian.com/commentisfree/2019/sep/24/elizabeth-warren-may-win-iowa-caucuses-simply-by-virtue-of-showing-up#img-1", puujgee);

        Post puujgeePost5 = new Post("Last night, for her first official evening engagement with Prince Harry, Meghan Markle wore an Alexander McQueen trouser suit. It was slim-fitting, with cropped cigarette trousers, worn with very high stiletto heels and a cream dishabille blouse.",
                LocalDate.of(2019, 2, 23), "https://www.theguardian.com/fashion/2018/feb/02/eco-chic-and-trouser-suits-how-meghan-markles-style-reads-the-room#img-1", puujgee);

        Post puujgeePost6 = new Post("Relatives and friends of those killed during the 2012 shooting in Aurora, Colorado have expressed concern over a gritty new take on Joker.",
                LocalDate.of(2019, 7, 21), "https://www.theguardian.com/film/2019/sep/24/families-of-aurora-shooting-victims-condemn-gun-violence-in-joker#img-1", puujgee);

        Post puujgeePost7 = new Post("Relatives and friends of those killed during the 2012 shooting in Aurora, Colorado have expressed concern over a gritty new take on Joker.",
                LocalDate.of(2019, 9, 12), "https://www.theguardian.com/film/2019/sep/24/families-of-aurora-shooting-victims-condemn-gun-violence-in-joker#img-1", puujgee);

        Post puujgeePost8 = new Post("Brad Pitt never looked more beautiful than in this mesmeric, flawed, superbly photographed and designed space adventure from director and co-writer James Gray. ",
                LocalDate.of(2019, 7, 11), "https://www.theguardian.com/film/2019/sep/18/ad-astra-review-brad-pitt-tommy-lee-jones-james-gray#img-1", puujgee);

        Post puujgeePost9 = new Post("Artificial intelligence is on a par with human experts when it comes to making medical diagnoses based on images, a review has found.",
                LocalDate.of(2019, 9, 25), "https://www.theguardian.com/technology/2019/sep/24/ai-equal-with-human-experts-in-medical-diagnosis-study-finds#img-1", puujgee);

        Post puujgeePost10 = new Post("Forget Apple’s much-vaunted iOS safeguards – attackers have been quietly breaking and entering for years",
                LocalDate.of(2019, 9, 25), "https://www.theguardian.com/technology/commentisfree/2019/sep/08/iphone-safe-from-hackers-think-again-ios-android-zero-day-exploit-zerodium-google-threat-analysis#img-1", puujgee);

        this.posts = new ArrayList<Post>(Arrays.asList(sodPost, turPost, puujgeePost, sodPost1));

        List<Post> sodPosts = sod.getPosts();
        sodPosts.add(sodPost);
        sodPosts.add(sodPost1);
        sodPosts.add(sodPost2);
        sodPosts.add(sodPost3);
        sodPosts.add(sodPost4);

        List<Post> turPosts = tur.getPosts();
        turPosts.add(turPost);
        turPosts.add(turPost1);
        turPosts.add(turPost2);
        turPosts.add(turPost3);
        turPosts.add(turPost4);

        List<Post> puujgeePosts = puujgee.getPosts();
        puujgeePosts.add(puujgeePost);
        puujgeePosts.add(puujgeePost1);
        puujgeePosts.add(puujgeePost2);
        puujgeePosts.add(puujgeePost3);
        puujgeePosts.add(puujgeePost4);
        puujgeePosts.add(puujgeePost5);
        puujgeePosts.add(puujgeePost6);
        puujgeePosts.add(puujgeePost7);
        puujgeePosts.add(puujgeePost8);
        puujgeePosts.add(puujgeePost9);
        puujgeePosts.add(puujgeePost10);


    }


    @Override
    public Post findPostById(Integer Id) {
        for (Post post : posts) {
            if (post.getId() == Id) return post;
        }
        return null;
    }

    @Override
    public List<Post> findRecentPostsByUsername(String username) {
        if (username == null) return null;
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (username.equalsIgnoreCase(post.getUser().getUsername()))
                result.add(post);
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public List<Post> findAllActiveFollowersRecentPosts(User user) {
        if (user == null) return null;
        List<Post> result = new ArrayList<>();
        for (Post p : findAllActiveRecentPosts()) {
            for (Integer i = 0; i < user.getFollowers().size(); i++) {
                if (p.getUser().getId() == user.getFollowers().get(i).getId() || p.getUser().getId() == user.getId())
                    result.add(p);
            }
        }
        return result;
    }

    @Override
    public List<Post> getHealthyPosts() {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.isHealthy()) {
                result.add(post);
            }
        }
        return result;
    }

    public boolean checkHealth(Post post) {
        String[] eachWords = "4r5e, cunt, punt, 5h1t, 5hit, a_s_s, a2m, a$$, a55, a$$hole, a55hole, adult, aeolus, ahole, amateur, anal, anal impaler , anal leakage , analprobe, anilingus, anus, ar5e, areola, areole, arian, arrse, arse, arsehole, aryan, ass, ass fuck , ass hole, ass-fucker, assbang, assbanged, assbangs, asses, assfuck, assfucker, assfukka, assh0le, asshat, assho1e, asshole, assholes, assmaster, assmucus , assmunch, asswhole, asswipe, asswipes, autoerotic, azazel, azz, b!tch, b00bs, b17ch, b1tch, babe, babes, ballbag, ballsack, bang, bang (one's) box , bangbros, banger, bareback, barf, bastard, bastards, bawdy, beaner, beardedclam, beastial, beastiality, beatch, beater, beaver, beef curtain , beer, beeyotch, bellend, beotch, bestial, bestiality, bi+ch, biatch, big tits, bigtits, bimbo, bimbos, birdlock, bitch, bitch tit , bitched, bitcher, bitchers, bitches, bitchin, bitching, bitchy, bloody, blow, blow job, blow me , blow mud , blowjob, blowjobs, blue waffle , blumpkin , bod, bodily, boink, boiolas, bollock, bollocks, bollok, bone, boned, boner, boners, bong, boob, boobies, boobs, booby, booger, bookie, booobs, boooobs, booooobs, booooooobs, bootee, bootie, booty, booze, boozer, boozy, bosom, bosomy, bowel, bowels, bra, brassiere, breast, breasts, buceta, bugger, bukkake, bull shit, bullshit, bullshits, bullshitted, bullturds, bum, bung, bunny fucker, bust a load , busty, butt, butt fuck, butt fuck , buttfuck, buttfucker, butthole, buttmuch, buttplug, c-0-c-k, c-o-c-k, c-u-n-t, c.0.c.k, c.o.c.k., c.u.n.t, c0ck, c0cksucker, caca, cahone, cameltoe, carpet muncher, carpetmuncher, cawk, cervix, chinc, chincs, chink, choade , chode, chodes, chota bags , cipa, cl1t, climax, clit, clit licker , clitoris, clitorus, clits, clitty, clitty litter , clusterfuck, cnut, cocain, cocaine, cock, cock pocket , cock snot , cock sucker, cock-sucker, cockblock, cockface, cockhead, cockholster, cockknocker, cockmunch, cockmuncher, cocks, cocksmoker, cocksuck, cocksucked, cocksucker, cocksucking, cocksucks, cocksuka, cocksukka, coital, cok, cokmuncher, coksucka, commie, condom, coon, coons, cop some wood , corksucker, cornhole , corp whore , cox, crabs, crack, cracker, crackwhore, crap, crappy, cum, cum chugger , cum dumpster , cum freak , cum guzzler , cumdump , cummer, cummin, cumming, cums, cumshot, cumshots, cumslut, cumstain, cunilingus, cunillingus, cunnilingus, cunny, cunt, cunt hair , cunt-struck , cuntbag , cuntface, cunthunter, cuntlick, cuntlick , cuntlicker, cuntlicker , cuntlicking , cunts, cuntsicle , cut rope , cyalis, cyberfuc, cyberfuck , cyberfucked, cyberfucker, cyberfuckers, cyberfucking, d0ng, d0uch3, d0uche, d1ck, d1ld0, d1ldo, dago, dagos, dammit, damn, damned, damnit, dawgie-style, dick, dick hole , dick shy , dick-ish, dickbag, dickdipper, dickface, dickflipper, dickhead, dickheads, dickish, dickripper, dicksipper, dickweed, dickwhipper, dickzipper, diddle, dike, dildo, dildos, diligaf, dillweed, dimwit, dingle, dink, dinks, dipship, dirsa, dirty Sanchez , dlck, dog-fucker, doggie style, doggie-style, doggiestyle, doggin, dogging, doggy-style, dong, donkeyribber, doofus, doosh, dopey, douch3, douche, douchebag, douchebags, douchey, drunk, duche, dumass, dumbass, dumbasses, dummy, dyke, dykes, eat a dick , eat hair pie , ejaculate, ejaculated, ejaculates, ejaculating, ejaculatings, ejaculation, ejakulate, enlargement, erect, erection, erotic, essohbee, extacy, extasy, f u c k, f u c k e r, f_u_c_k, f-u-c-k, f.u.c.k, f4nny, facial , fack, fag, fagg, fagged, fagging, faggit, faggitt, faggot, faggs, fagot, fagots, fags, faig, faigt, fanny, fannybandit, fannyflaps, fannyfucker, fanyy, fart, fartknocker, fat, fatass, fcuk, fcuker, fcuking, feck, fecker, felch, felcher, felching, fellate, fellatio, feltch, feltcher, fingerfuck, fingerfucked, fingerfucker , fingerfuckers, fingerfucking, fingerfucks, fist fuck , fisted, fistfuck, fistfucked, fistfucker , fistfuckers, fistfucking, fistfuckings, fistfucks, fisting, fisty, flange, flog the log , floozy, foad, fondle, foobar, fook, fooker, foreskin, freex, frigg, frigga, fubar, fuck, fuck , fuck hole , fuck puppet , fuck trophy , fuck yo mama , fuck-ass , fuck-bitch , fuck-tard, fucka, fuckass, fucked, fucker, fuckers, fuckface, fuckhead, fuckheads, fuckin, fucking, fuckings, fuckingshitmotherfucker, fuckme, fuckmeat , fucknugget, fucknut, fuckoff, fucks, fucktard, fucktoy , fuckup, fuckwad, fuckwhit, fuckwit, fudge packer, fudgepacker, fuk, fuker, fukker, fukkin, fuks, fukwhit, fukwit, fux, fux0r, fvck, fxck, g-spot, gae, gai, gang-bang , gangbang, gangbang , gangbanged, gangbangs, ganja, gassy ass , gay, gaylord, gays, gaysex, gey, gfy, ghay, ghey, gigolo, glans, goatse, god, god damn, god-dam, god-damned, godamn, godamnit, goddam, goddammit, goddamn, goddamned, goldenshower, gonad, gonads, gook, gooks, gringo, gspot, gtfo, guido, h0m0, h0mo, ham flap , handjob, hard on, hardcoresex, he11, hebe, heeb, hell, hemp, heroin, herp, herpes, herpy, heshe, hitler, hiv, hoar, hoare, hobag, hoer, hom0, homey, homo, homoerotic, homoey, honky, hooch, hookah, hooker, hoor, hootch, hooter, hooters, hore, horniest, horny, hotsex, how to kill, how to murdep, hump, humped, humping, hussy, hymen, inbred, incest, injun, j3rk0ff, jack-off, jackass, jackhole, jackoff, jap, japs, jerk, jerk-off, jerk0ff, jerked, jerkoff, jism, jiz, jizm, jizz, jizzed, junkie, junky, kawk, kike, kikes, kill, kinky, kinky Jesus , kkk, klan, knob, knob end, knobead, knobed, knobend, knobhead, knobjocky, knobjokey, kock, kondum, kondums, kooch, kooches, kootch, kraut, kum, kummer, kumming, kums, kunilingus, kwif , kyke, l3i+ch, l3itch, labia, lech, LEN, leper, lesbians, lesbo, lesbos, lez, lezbian, lezbians, lezbo, lezbos, lezzie, lezzies, lezzy, lmao, lmfao, loin, loins, lube, lust, lusting, lusty, m-fucking, m0f0, m0fo, m45terbate, ma5terb8, ma5terbate, mafugly , mams, masochist, massa, master-bate, masterb8, masterbat*, masterbat3, masterbate, masterbating, masterbation, masterbations, masturbate, masturbating, masturbation, maxi, menses, menstruate, menstruation, meth, mo-fo, mof0, mofo, molest, moolie, moron, mothafuck, mothafucka, mothafuckas, mothafuckaz, mothafucked, mothafucker, mothafuckers, mothafuckin, mothafucking, mothafuckings, mothafucks, mother fucker, mother fucker , motherfuck, motherfucka, motherfucked, motherfucker, motherfuckers, motherfuckin, motherfucking, motherfuckings, motherfuckka, motherfucks, mtherfucker, mthrfucker, mthrfucking, muff, muff puff , muffdiver, murder, mutha, muthafecker, muthafuckaz, muthafucker, muthafuckker, muther, mutherfucker, mutherfucking, muthrfucking, n1gga, n1gger, nad, nads, naked, napalm, nappy, nazi, nazism, need the dick , negro, nigg3r, nigg4h, nigga, niggah, niggas, niggaz, nigger, niggers, niggle, niglet, nimrod, ninny, nipple, nob, nob jokey, nobhead, nobjocky, nobjokey, nooky, numbnuts, nut butter , nutsack, nympho, omg, opiate, opium, oral, orally, organ, orgasim , orgasims , orgasm, orgasmic, orgasms , orgies, orgy, ovary, ovum, ovums, p.u.s.s.y., p0rn, paddy, paki, pantie, panties, panty, pastie, pasty, pawn, pcp, pecker, pedo, pedophile, pedophilia, pedophiliac, pee, peepee, penetrate, penetration, penial, penile, penis, penisfucker, perversion, peyote, phalli, phallic, phonesex, phuck, phuk, phuked, phuking, phukked, phukking, phuks, phuq, pigfucker, pillowbiter, pimp, pimpis, pinko, piss, piss-off, pissed, pisser, pissers, pisses , pissflaps, pissin, pissing, pissoff, pissoff , pms, polack, pollock, poon, poontang, poop, porn, porno, pornography, pornos, pot, potty, prick, pricks, prig, pron, prostitute, prude, pube, pubic, pubis, punkass, punky, puss, pusse, pussi, pussies, pussy, pussy fart , pussy palace , pussypounder, pussys, puto, queaf, queaf , queef, queer, queero, queers, quicky, quim, r-tard, racy, rape, raped, raper, rapist, raunch, rectal, rectum, rectus, reefer, reetard, reich, retard, retarded, revue, rimjaw, rimjob, rimming, ritard, rtard, rum, rump, rumprammer, ruski, s hit, s_h_i_t, s-h-1-t, s-h-i-t, s-o-b, s.h.i.t., s.o.b., s0b, sadism, sadist, sandbar , sausage queen , scag, scantily, schizo, schlong, screw, screwed, screwing, scroat, scrog, scrot, scrote, scrotum, scrud, scum, seaman, seamen, seduce, semen, sex, sexual, sh!+, sh!t, sh1t, shag, shagger, shaggin, shagging, shamedame, shemale, shi+, shit, shit fucker , shitdick, shite, shiteater, shited, shitey, shitface, shitfuck, shitfull, shithead, shithole, shithouse, shiting, shitings, shits, shitt, shitted, shitter, shitters, shitting, shittings, shitty, shiz, sissy, skag, skank, slave, sleaze, sleazy, slope , slut, slut bucket , slutdumper, slutkiss, sluts, smegma, smut, smutty, snatch, sniper, snuff, sodom, son-of-a-bitch, souse, soused, spac, sperm, spic, spick, spik, spiks, spooge, spunk, steamy, stfu, stiffy, stoned, strip, stroke, stupid, suck, sucked, sucking, sumofabiatch, t1t, t1tt1e5, t1tties, tampon, tard, tawdry, teabagging, teat, teets, teez, terd, teste, testee, testes, testical, testicle, testis, thrust, thug, tinkle, tit, tit wank , titfuck, titi, tits, titt, tittie5, tittiefucker, titties, titty, tittyfuck, tittyfucker, tittywank, titwank, toke, toots, tosser, tramp, transsexual, trashy, tubgirl, turd, tush, tw4t, twat, twathead, twats, twatty, twunt, twunter, ugly, undies, unwed, urinal, urine, uterus, uzi, v14gra, v1gra, vag, vagina, valium, viagra, virgin, vixen, vodka, vomit, voyeur, vulgar, vulva, w00se, wad, wang, wank, wanker, wanky, wazoo, wedgie, weed, weenie, weewee, weiner, weirdo, wench, wetback, wh0re, wh0reface, whitey, whiz, whoar, whoralicious, whore, whorealicious, whored, whoreface, whorehopper, whorehouse, whores, whoring, wigger, willies, willy, womb, woody, wop, wtf, x-rated, xrated, xxx, yeasty, yobbo, zoophile".split(", ");
        System.out.println("eachWords = " + eachWords.toString());
        String[] cont = post.getContent().split(" ");
        for (int i = 0; i < cont.length; i++) {
            //post.setHealth(true);
            for (int j = 0; j < eachWords.length; j++) {
                if (cont[i].equalsIgnoreCase(eachWords[j])) {
                    post.setHealth(false);
                    break;
                }
            }
        }
        return post.isHealthy();
    }

    @Override
    public List<Post> findAllActiveRecentPosts() {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.getActive()) result.add(post);
        }
        Collections.sort(result);
        //System.out.println("Posts by ordered: = " + result);
        return result;
    }

    @Override
    public void addPost(User user, Post post) {
        if (user == null && post == null) return;
        if (post.getUser() == null) post.setUser(user);

        checkHealth(post);

        List<Post> postList = user.getPosts();
        postList.add(post);
        user.setPosts(postList);
        posts.add(post);
    }

    @Override
    public List<Post> findAllPosts() {
        for (Post p : posts) {
            checkHealth(p);
        }
        return posts;
    }

    public Post getPostById(Integer id) {
        for (Post p : posts) {
            System.out.println("p = " + p);
            if (p.getId().equals(id))
                return p;
        }

        return null;
    }
}

