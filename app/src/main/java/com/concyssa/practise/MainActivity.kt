package com.concyssa.practise

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.concyssa.practise.ui.theme.PractiseComposeCampTheme


private val messages: List<MyMessage> = listOf(
    MyMessage("Hello user Leonardo", "¿Are you ready? Quisque bibendum rutrum blandit. Aliquam et sem non sem tincidunt efficitur. Nullam euismod purus sed finibus bibendum. Integer a posuere dolor, et maximus elit. Morbi placerat tincidunt eros non dapibus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec eu turpis at nisl finibus ultricies convallis sit amet lacus. Aliquam justo nunc, molestie non luctus vel, volutpat ut lacus. Maecenas eu blandit dui, sed laoreet lectus. In velit nibh, tincidunt id tincidunt dapibus, ultricies vitae urna."),
    MyMessage("Hello user Leonardo 2", "¿Are you ready? Sed tempus congue felis. Suspendisse semper justo at semper suscipit. Nullam varius risus et ipsum mollis imperdiet ut nec est. Suspendisse nec purus lorem. Nunc auctor ex vel odio viverra, quis consectetur sem fermentum. In facilisis purus id dui gravida volutpat. Nullam in accumsan felis, id accumsan justo. Pellentesque enim quam, dictum et tincidunt at, porttitor vel mauris. Curabitur sed faucibus urna, pulvinar tincidunt mi. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec mollis in odio sit amet pulvinar."),
    MyMessage("Hello user Leonardo 3", "¿Are you ready? Praesent auctor luctus ornare. Cras consectetur libero sit amet bibendum dapibus. Duis mollis ligula eget placerat sagittis. Phasellus nisi erat, iaculis quis nisl eu, facilisis consequat dui. Duis luctus accumsan massa vitae ultricies. Ut in lorem quis lorem rutrum elementum quis ac nisi. Duis imperdiet augue est, a dapibus ex accumsan vitae. Donec tincidunt volutpat massa semper dignissim. Proin volutpat arcu in molestie gravida. Sed nec lacus pulvinar, lacinia enim eget, congue neque. Suspendisse suscipit lacinia lorem, vitae efficitur lectus hendrerit ut. Pellentesque lacinia pellentesque nisl at maximus. Cras dignissim neque vehicula, rhoncus felis id, mollis diam. Fusce non pellentesque nunc. Proin euismod sagittis auctor. Mauris mattis consequat magna at aliquam."),
    MyMessage("Hello user Leonardo 4", "¿Are you ready? Donec eget lorem ornare, congue libero et, euismod risus. Suspendisse at leo vel dolor ultricies posuere. Cras enim magna, tincidunt nec lacus in, venenatis commodo ante. Pellentesque vitae dignissim eros. Quisque tempus rutrum semper. Morbi cursus tristique pretium. Fusce facilisis orci in arcu bibendum placerat. Vestibulum varius, ex eget efficitur malesuada, augue risus bibendum eros, vitae hendrerit purus mauris quis lacus. Sed eget lobortis nunc."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Etiam vestibulum enim urna, at malesuada odio varius vitae. Praesent sem sem, suscipit sed lacinia id, porta id ex. Aenean at aliquet nibh. Praesent vehicula nulla placerat, rutrum tortor eu, posuere mi. Fusce sit amet elementum nunc. Donec sit amet sapien vehicula, dignissim metus sit amet, gravida ante. Morbi sed gravida lacus, tincidunt molestie arcu. Vestibulum porta lobortis nisl, id egestas dui malesuada et. Nunc vel purus gravida orci molestie porta non dignissim quam. Ut quis dolor est. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nunc ut volutpat arcu. Sed finibus congue lectus in accumsan. Quisque imperdiet, odio non eleifend blandit, orci elit laoreet ante, in feugiat massa dui nec nunc."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Ut nec nisi sed turpis fermentum condimentum. Sed eros quam, lacinia consectetur pellentesque ut, iaculis et arcu. Etiam sed nunc nec neque dapibus rutrum. Morbi laoreet sodales arcu, vel vehicula quam dignissim quis. Nam non neque mollis, posuere risus sed, imperdiet quam. In egestas neque ut volutpat ullamcorper. Proin ultrices est dolor. Proin volutpat iaculis efficitur. Maecenas vel nunc vel felis lacinia mollis. Morbi et sem tempus dolor euismod congue nec nec massa. Duis porta nulla nibh, a posuere diam ullamcorper at. Vestibulum justo est, condimentum quis nisl eget, tincidunt blandit mauris. Phasellus maximus egestas lorem, at convallis tellus dapibus et. Curabitur sodales et leo quis ultrices."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Pellentesque non nunc orci. Pellentesque gravida fringilla gravida. Aliquam sit amet justo viverra, dictum felis vitae, sollicitudin quam. Vivamus vitae sodales neque. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Cras ullamcorper eget elit vel efficitur. Proin cursus, ligula a efficitur ultrices, sem nibh tempor nulla, molestie varius ipsum enim dictum tortor. Aenean iaculis, velit non cursus rhoncus, urna diam fringilla velit, eu ultricies nisl velit sed purus. Ut diam est, euismod id faucibus sit amet, faucibus et mauris. Aenean tristique pretium lorem, eget dignissim mi imperdiet eget. Duis ultricies, tellus at auctor suscipit, justo tortor pharetra turpis, et pulvinar nibh tellus sed odio. Etiam sed molestie libero"),
    MyMessage("Hello user Leonardo", "¿Are you ready? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mattis, nisl consectetur tempor feugiat, dolor lectus pharetra sem, ut molestie diam dui vitae nisi. Integer dictum ex ut enim fermentum, non eleifend arcu suscipit. Pellentesque efficitur, diam sit amet mattis vehicula, dui arcu tincidunt orci, vitae dapibus velit massa vel risus. Morbi ut ipsum porta, finibus arcu vel, dignissim odio. Pellentesque congue tincidunt pellentesque. In iaculis tortor a ligula convallis pharetra. Vivamus sodales augue ut mi ullamcorper maximus at vitae erat. Duis quis justo arcu. Suspendisse potenti."),
    MyMessage("Hello user Leonardo 10", "¿Are you ready? Nullam velit mi, aliquam ut mi a, vulputate imperdiet lorem. Suspendisse nunc est, ullamcorper at erat at, auctor tincidunt lacus. Sed eu commodo magna. Praesent ipsum ex, efficitur at mi ac, fringilla sollicitudin dolor. Sed luctus porta tristique. Aenean eu accumsan massa. Vivamus pharetra orci eget rutrum pulvinar. Nunc at tortor lacus. Fusce in pretium lorem. Nam sit amet elementum metus, vel viverra ligula."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Sed imperdiet imperdiet consectetur. In id vehicula orci. Quisque volutpat nisi eu congue laoreet. Sed egestas sem mi, sed pharetra magna iaculis sed. Ut volutpat commodo augue id tincidunt. Proin sit amet tincidunt eros, a sodales metus. Pellentesque sed ultrices lorem. Pellentesque varius condimentum mauris sed laoreet."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Aenean blandit interdum urna, quis eleifend metus varius sit amet. Sed vestibulum diam eget odio egestas, vitae eleifend dui cursus. Vestibulum tempor, nulla ut tempor pharetra, lorem diam placerat ex, sed tincidunt ex ligula ac lorem. In aliquet ornare nulla vitae rutrum. Nunc tempus sem vitae porta feugiat. Etiam sollicitudin rhoncus justo et pellentesque. Curabitur euismod orci nec felis posuere mollis. Phasellus euismod interdum quam, ut commodo elit sodales dictum. Curabitur euismod, est eget dapibus pharetra, ipsum tortor consequat elit, nec bibendum mi massa lacinia ligula. Etiam blandit justo quis elit varius condimentum. Fusce euismod eu tellus nec malesuada. Duis sollicitudin erat ut arcu sodales, ac rutrum elit tempus. Aenean quis nisi purus. Etiam ut faucibus ante."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Etiam consectetur dictum elit in pretium. Suspendisse congue at enim in blandit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus pretium blandit neque, in aliquam elit placerat nec. Etiam aliquet nunc bibendum erat ultrices, eu iaculis mauris vulputate. Sed sit amet est at purus pellentesque imperdiet dictum quis eros. Vivamus sed tellus at nunc viverra lobortis. Vestibulum rutrum, quam at commodo egestas, enim velit consequat libero, eu ultricies dolor neque a lorem. Cras pharetra, enim eu condimentum aliquet, odio ligula eleifend mi, in convallis odio libero quis mi. Nulla facilisi. Duis dictum at ipsum sit amet vulputate. Praesent feugiat augue eget elit hendrerit rutrum. Fusce imperdiet et odio at viverra. Quisque erat diam, tempus a porttitor non, tincidunt eu lorem. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean sodales lorem at est sagittis ullamcorper."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Curabitur ornare molestie condimentum. Pellentesque tristique est non lacus ullamcorper laoreet at et magna. Aenean tincidunt dictum ipsum sed placerat. Duis sed massa nec libero malesuada viverra a id ante. Aliquam vulputate efficitur purus non efficitur. Vivamus accumsan sit amet urna sit amet vehicula. Curabitur imperdiet, eros et mattis auctor, mauris dolor hendrerit nulla, eget varius nisi augue non est. Praesent dui dui, ullamcorper at nisl at, euismod vehicula sapien. Vivamus eget lacus dolor. Donec ac scelerisque eros, semper porttitor tortor. Vestibulum et mi suscipit, fringilla mauris eget, lacinia purus. Mauris mattis dui lacinia arcu eleifend, a vulputate felis feugiat. Pellentesque condimentum mi ac orci accumsan condimentum. Sed laoreet dui ac libero elementum, sit amet blandit mauris accumsan. Etiam ullamcorper dictum elementum."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Phasellus commodo turpis molestie purus mollis, tincidunt condimentum neque dapibus. Nulla pulvinar augue vel leo eleifend, vel tempor elit eleifend. Fusce sit amet eros id justo vehicula molestie vitae sed ante. Aliquam a mauris eu ex finibus scelerisque sed at nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla id metus bibendum, maximus erat vel, pretium dui. Quisque tempor aliquet enim, quis lacinia dolor rhoncus vitae. Vivamus id ligula eget urna sollicitudin tincidunt quis vel lacus. Nam vehicula metus at risus interdum, eget vestibulum dolor facilisis. Pellentesque nec est id libero venenatis malesuada in sit amet ex. Sed ante massa, pellentesque vel euismod fermentum, euismod eu est. In eu velit viverra, aliquet urna quis, venenatis magna. Mauris odio massa, molestie quis risus ut, fringilla congue nulla. Nullam mattis eros eget augue dapibus, ut tincidunt tortor dapibus. Sed dignissim odio nec pretium malesuada."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Nunc dictum pharetra turpis et eleifend. Donec ut imperdiet orci. Curabitur vel ex sed enim commodo iaculis eget nec nibh. Pellentesque hendrerit quam eget rutrum dapibus. Sed maximus lacus eu mi vehicula mollis. Nulla urna justo, pretium id ipsum sed, ullamcorper dignissim ex. Vestibulum fringilla finibus bibendum. Quisque convallis justo varius massa mollis tempus. Vivamus consequat semper arcu. Suspendisse potenti. Phasellus lacus leo, varius at sapien sodales, scelerisque efficitur metus. Donec euismod non urna eu feugiat. Aliquam semper laoreet sem, eget auctor ligula ornare nec."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Nullam ac porttitor lorem. Ut vestibulum scelerisque viverra. Sed in leo ac lacus consectetur scelerisque. Morbi scelerisque, orci in dapibus vehicula, tellus risus tempus urna, a mollis mi nisl eu erat. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec id pellentesque ante. Ut diam magna, vulputate sed congue sit amet, blandit a lacus. Nunc bibendum libero a turpis molestie, non euismod lacus finibus. Aliquam eget sapien nec magna sollicitudin ultrices. In eu sem non est mattis efficitur. Integer aliquam, sem id imperdiet vehicula, mauris nulla dapibus orci, efficitur auctor massa libero quis eros. Cras neque ex, ultrices eu turpis vel, fermentum viverra lorem. Praesent nec semper neque."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Pellentesque at massa gravida, commodo orci id, porttitor nibh. Vivamus arcu libero, laoreet non arcu vel, finibus vestibulum velit. Donec at arcu magna. Donec efficitur elementum convallis. Aliquam mauris est, eleifend sit amet ligula a, tincidunt consequat nibh. Donec placerat sapien nec eros venenatis, vitae aliquam neque feugiat. Nulla rutrum lobortis imperdiet. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris auctor nisi at dolor posuere interdum. Nunc sodales, diam eu scelerisque dignissim, ante augue hendrerit lacus, sed laoreet arcu erat id magna. Mauris vitae gravida lectus. Nullam finibus nisi porttitor lacus pretium, quis congue risus auctor."),
    MyMessage("Hello user Leonardo", "¿Are you ready? Fusce maximus libero elit, sit amet bibendum ipsum hendrerit a. Integer fringilla mauris at magna scelerisque iaculis. Suspendisse at porta arcu. Phasellus sodales nunc nisi, id dignissim metus ullamcorper quis. Aenean at mi odio. Sed posuere porta velit, eu pulvinar nibh euismod nec. Ut nisi est, ornare sed sagittis eget, commodo id lacus. Sed placerat sapien purus, at viverra eros venenatis at. In efficitur dolor eu nibh vestibulum, id ultrices magna sagittis.")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             PractiseComposeCampTheme {
                 MyMessages(messages)
             }
        }
    }
}

data class MyMessage(val title: String, val body: String)



@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages){ message->
            MyComponent(message)
        }
    }

}


@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)){
        MyImage()
        MyTexts(message)
    }
}


@Composable
fun MyImage(){
    Image(painterResource(R.drawable.ic_launcher_foreground) ,
        "My Image of Test",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)

    )
}

@Composable
fun MyTexts(message: MyMessage){

      var expanded by remember { mutableStateOf(false)}

      Column(modifier = Modifier.padding(start = 8.dp).clickable {
            expanded = !expanded
      }) {
          MyText(
          text = message.title,
          MaterialTheme.colors.primary,
          MaterialTheme.typography.subtitle1
          )

          Spacer(modifier = Modifier.height(16.dp))

          MyText(
          text = message.body,
          MaterialTheme.colors.onBackground,
          MaterialTheme.typography.subtitle2,
          if (expanded) Int.MAX_VALUE else 1
          )
      }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style= style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    PractiseComposeCampTheme {
//        val scrollState = rememberScrollState()
//        Column(modifier = Modifier.verticalScroll(scrollState)) {
            MyMessages(messages)
//        }
    }
}