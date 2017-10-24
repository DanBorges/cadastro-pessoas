var gulp = require("gulp");
var sass = require("gulp-sass");
var notify = require("gulp-notify");
var concat = require("gulp-concat");
var uglify = require("gulp-uglify");

var scss = [
	'./app/assets/stylesheets/*.scss'
];

// var js = [
// 	'./public/javascripts/vendor/locale/*.js',
// 	'./public/javascripts/vendor/angular-route.min.js',
// 	'./public/javascripts/vendor/angular-cookies.min.js',
// 	'./public/javascripts/vendor/angular-translate.js',
// 	'./public/javascripts/vendor/angular-md5.js',
// 	'./public/javascripts/vendor/i18n/*.js',
// 	'./public/javascripts/vendor/jquery-1.11.3.min.js',
// 	'./public/javascripts/vendor/jquery-ui.min.js',
// 	'./public/javascripts/vendor/ui-bootstrap-tpls-0.13.3.min.js',
// 	'./public/javascripts/vendor/bootstrap.min.js',
// 	'./public/javascripts/vendor/moment.min.js',
// 	'./public/javascripts/vendor/d3.min.js',
// 	'./public/javascripts/vendor/c3.min.js',
// 	'./public/javascripts/vendor/topojson.v1.js',
// 	'./public/javascripts/vendor/rgbcolor.js',
// 	'./public/javascripts/vendor/StackBlur.js',
// 	'./public/javascripts/vendor/jquery.blockUI.min.js',
// 	'./public/javascripts/vendor/chroma.min.js',
// 	'./public/javascripts/vendor/fullcalendar.js',
// 	'./public/javascripts/util/*.js',
// 	'./public/controller/*.js'
// ];

gulp.task('compile-scss', function() {
	return gulp.src(scss)
			.pipe(sass({outputStyle:'compressed'}))
			.on('error', notify.onError({title: 'Erro ao compilar', message: '<%= error.message %>'}))
			.pipe(gulp.dest("./public/stylesheets/css"))
});

gulp.task('watch', function() {
	gulp.watch(scss, ['compile-scss']);
});

gulp.task('scripts', function() {
  return gulp.src('./lib/*.js')
    .pipe(concat('all.js'))
    .pipe(gulp.dest('./dist/'));
});
