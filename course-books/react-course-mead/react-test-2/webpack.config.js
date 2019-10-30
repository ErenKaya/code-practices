const path = require("path");
const fs = require("fs");
const readline = require("readline");
const { exec } = require("child_process");
exec("javac .srcjavaTranslateConstants.java", null);

exec("java src.java.TranslateConstants", { cwd: ".." }, (err, stdout, stderr) => {
   if (err) {
      console.log("er", err);
      return;
   }

   console.log(`stdout: ${stdout}`);
   console.log(`stderr: ${stderr}`);
});

// async function processLineByLine() {
//    const readlineInterface = readline.createInterface({
//       input: fs.createReadStream("src/java-source/TranslateConstants.java"),
//       output: process.stdout
//    });

//    prepareJsTranslateFile(readlineInterface);
// }

// processLineByLine();

async function prepareJsTranslateFile(readlineInterface) {
   try {
      fs.unlinkSync("src/js-source/TranslateConstants.js");
   } catch (error) {
      console.log("File couldn't delete", error);
   }
   const writeInterface = fs.createWriteStream("src/js-source/TranslateConstants.js");
   writeInterface.write("export default TranslateConstants =");
   let data = {};
   for await (const line of readlineInterface) {
      prepareKeyWordFromFlatLineData(line, data);
      console.log("data in for", line);
   }
   writeInterface.write(JSON.stringify(data));
   writeInterface.end();
}
// prepareKeyWordFromFlatLineData = (line, data) => {
//    console.log("line");
//    if (line.indexOf("public") !== -1 && line.indexOf("static") !== -1) {
//       const key = line
//          .substring(line.indexOf("String"), line.indexOf("="))
//          .replace("String", "")
//          .trim();
//       data[key] = key;
//    }
// };

module.exports = {
   entry: "./src/app.js",
   output: {
      path: path.join(__dirname, "public"),
      filename: "bundle.js"
   },
   module: {
      rules: [
         {
            loader: "babel-loader",
            test: /\.js$/,
            exclude: /node_modules/
         },
         {
            test: /\.css$/,
            use: ["style-loader", "css-loader"]
         }
      ]
   },
   devtool: "cheap-module-eval-source-map",
   devServer: {
      contentBase: path.join(__dirname, "public")
   }
};
